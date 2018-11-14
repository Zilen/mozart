package regra.melodia;

import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.NotaTocada;

public class RegraDiminuirDuracaoNotaForaDoAcorde extends RegraMelodiaMultiplicador {

	private Duracao maiorDuracao;

	public RegraDiminuirDuracaoNotaForaDoAcorde(Duracao maiorDuracao) {
		super(0.5);
		this.maiorDuracao = maiorDuracao;
	}
	public RegraDiminuirDuracaoNotaForaDoAcorde(double multiplicador, Duracao maiorDuracao) {
		super(multiplicador);
		this.maiorDuracao = maiorDuracao;
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public Boolean executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		for(Probabilidade<NotaTocada> a : acao) {
			if (a.get().getDuracao().getDuracao() < maiorDuracao.getDuracao())
				a.multiplicarChance(multiplicador);
		}
		return false;
	}

}
