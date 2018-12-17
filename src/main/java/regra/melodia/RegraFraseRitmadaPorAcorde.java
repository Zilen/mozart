package regra.melodia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Utils.Rand;
import acao.Probabilidade;
import acao.melodia.MelodiaAcaoProcessor;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.Melodia;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class RegraFraseRitmadaPorAcorde extends RegraMelodiaMultiplicador  {

	private LinkedList<Double> pontuacao;
	private Duracao duracaoIdeal;
	private List<RegraMelodia> regrasFactiveis;

	public RegraFraseRitmadaPorAcorde(Double chance, Duracao duracaoIdeal, Double... pontuacaoArray) {
		super(chance);
		this.pontuacao = new LinkedList<Double>(Arrays.asList(pontuacaoArray));
		Collections.sort(this.pontuacao);
		this.duracaoIdeal = duracaoIdeal;
		this.regrasFactiveis = new ArrayList<RegraMelodia>();
	}

	public void addRegra(RegraMelodia... regras) {
		this.regrasFactiveis.addAll(Arrays.asList(regras));
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return musica.getTempoCalculadoAtual() % musica.getTempoPorCompasso() == 0.0;
	}

	@Override
	public Boolean executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		acao = MelodiaAcaoProcessor.gerarProbabilidadeAcordeEscala(musica, 0.0, 0.6*this.getMultiplicador(), 0.9*this.getMultiplicador());
		int atual = 0;
		for (Double pontuacao : this.pontuacao) {
			if(atual == 0.0 && pontuacao > 0.0) {
				this.preencherPausa(musica.getMelodia(), pontuacao, musica);
				atual++;
				continue;
			}
			atual++;
			double tempoMedido = getTempoAserUtilizado(atual, musica.getTempoPorCompasso());
			for (Probabilidade<NotaTocada> a : acao) {
				if (a.get().getDuracao().getDuracaoReal() <= tempoMedido) {
					a.atualizarChance(super.getMultiplicador());
					if (a.get().getDuracao().equals(this.duracaoIdeal)) {
						a.multiplicarChance(3.0);
					}
				} else {
					a.atualizarChance(0.0);
				}
			}
			double soma = acao.stream().mapToDouble(d -> d.getChance()).sum();
			super.recalcular(acao);
			processarRegras(acao, musica, iteration);
			NotaTocada notaEscolhida = super.escolher(acao, Rand.nextDouble());
			musica.getMelodia().addNota(notaEscolhida, musica);
			this.preencherPausa(musica.getMelodia(), tempoMedido - notaEscolhida.getDuracao().getDuracaoReal(), musica);
		}


		return true;
	}


	private void processarRegras(List<Probabilidade<NotaTocada>> acao, Musica musica, Integer iteration) {
		if (!this.regrasFactiveis.isEmpty()) {
			for (RegraMelodia regra : this.regrasFactiveis) {
				regra.validarExecutar(acao, musica, iteration, musica.getMelodia());
			}
		}
	}

	private double getTempoAserUtilizado(int atual, Integer tempoCompasso) {
		if(atual == this.pontuacao.size()) {
			double inicial = this.pontuacao.get(0);
			if(tempoCompasso - this.pontuacao.get(atual-1) < Duracao.FUSA.getDuracaoReal()) {
				return inicial + tempoCompasso.doubleValue() - this.pontuacao.get(atual-1);
			} else {
				return tempoCompasso - this.pontuacao.get(atual-1);
			}
		} else {
			return this.pontuacao.get(atual) - this.pontuacao.get(atual-1);
		}
	}

	private void preencherPausa(Melodia melodia, double d, Musica musica) {
		double somaDuracao = 0.0;
		if (d == 0.0) {
			return;
		}
		List<Duracao> listaDuracao = Duracao.getByDuracaoReal(d);

		for (Duracao duracao : listaDuracao) {
			melodia.addNota(new NotaTocada(Som.PAUSA, null, duracao), musica);
			somaDuracao+=duracao.getDuracaoReal();
		}
		if (somaDuracao != d) {
			throw new AssertionError();
		}
	}

}
