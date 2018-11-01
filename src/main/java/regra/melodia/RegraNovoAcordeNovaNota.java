package regra.melodia;

import java.util.ArrayList;
import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.NotaTocada;

public class RegraNovoAcordeNovaNota extends RegraMelodia {

	private double multiplicador = 0.50;
	private double tempoAtual;
	private double tempoMaximoIncremental = 0.5;

	public RegraNovoAcordeNovaNota(double multiplicador, double tempoAtual,
			double tempoMaximoIncremental) {
		super();
		this.multiplicador = multiplicador;
		this.tempoAtual = tempoAtual;
		this.tempoMaximoIncremental = tempoMaximoIncremental;
	}
	public RegraNovoAcordeNovaNota() {
		super();
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		this.tempoAtual = musica.getTempoCalculadoAtual();
		return musica.getTempoCalculadoAtual() != 0.0
				&& musica.getTempoCalculadoAtual() % musica.getTempoPorCompasso().doubleValue() != 0.0
				&& Duracao.getByDuracaoReal(musica.getTempoPorCompasso().doubleValue() - (tempoAtual % musica.getTempoPorCompasso().doubleValue())) != null;
	}

	@Override
	public void executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		Double tempoMinimo = tempoAtual % musica.getTempoPorCompasso().doubleValue();
		Double limiteMaximo = tempoMinimo + tempoMaximoIncremental;

		List<Duracao> duracoesASeremReduzidas = new ArrayList<Duracao>();

		for (Duracao d : Duracao.values()) {
			if (d.getDuracaoReal() >= tempoMinimo && d.getDuracaoReal() < limiteMaximo) {
				duracoesASeremReduzidas.add(d);
			}
		}

		Duracao duracao = Duracao.getByDuracaoReal(tempoAtual);
		for(Probabilidade<NotaTocada> a : acao) {
			if (duracoesASeremReduzidas.contains(a.get().getDuracao()))
			a.multiplicarChance(multiplicador);
		}
	}

}
