package regra.melodia;

import java.util.Arrays;
import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.NotaTocada;

public class RegraDiminuirChancesDuracao extends RegraMelodiaMultiplicador {

	private List<Duracao> duracoes;

	public RegraDiminuirChancesDuracao(double multiplicador, Duracao... duracoes) {
		super(multiplicador);
		this.duracoes = Arrays.asList(duracoes);
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public Boolean executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		for (Probabilidade<NotaTocada> a : acao) {
			if (duracoes.contains(a.get().getDuracao()))
				a.multiplicarChance(multiplicador);
		}
		return false;
	}
}
