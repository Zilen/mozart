package regra.melodia;

import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.nota.NotaTocada;

public class RegraDiminuirChancesDuracao extends RegraMelodiaMultiplicador {

	private Duracao duracao;

	public RegraDiminuirChancesDuracao(double multiplicador, Duracao duracao) {
		super(multiplicador);
		this.duracao = duracao;
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public void executar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		for(Probabilidade<NotaTocada> a : acao) {
			if (a.get().getDuracao().equals(duracao))
			a.multiplicarChance(multiplicador);
		}
	}

}
