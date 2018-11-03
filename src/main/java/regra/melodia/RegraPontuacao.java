package regra.melodia;

import java.util.Arrays;
import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.NotaTocada;

public class RegraPontuacao extends RegraMelodiaMultiplicador {

	private double multiplicador = 0.50;
	private List<Double> temposPontuados;

	public RegraPontuacao(Duracao maiorDuracao, Double... temposPontuados) {
		super(0.5);
		this.temposPontuados = Arrays.asList(temposPontuados);
	}
	public RegraPontuacao(double multiplicador) {
		super(multiplicador);
		this.multiplicador = multiplicador;
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public void executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		double tempo = musica.getTempoCalculadoAtual() % musica.getTempoPorCompasso();
		double duracaoAcorde = super.getNotasInCompasso().stream().mapToDouble(a -> a.getDuracao().getDuracaoReal()).sum();
		List<Duracao> tempoProximaPontuacao = null;
		
		for(double t : temposPontuados) {
			if (t > tempo) {
				double tempoProximaPontuacaoDouble = t - tempo;
				if(tempoProximaPontuacaoDouble > 0) {
					tempoProximaPontuacao = Duracao.getByDuracaoReal(tempoProximaPontuacaoDouble);
					break;
				}
			}
		}
		if (tempoProximaPontuacao == null) {
			tempoProximaPontuacao = Duracao.getByDuracaoReal(temposPontuados.get(0) + musica.getTempoPorCompasso() - duracaoAcorde);
		}
			
		
		for(Probabilidade<NotaTocada> a :acao) {
			if(a.get().getDuracao().equals(tempoProximaPontuacao)) {
				a.multiplicarChance(multiplicador);
			}
			
		}
	}

}
