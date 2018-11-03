package regra.melodia;

import java.util.List;

import acao.Probabilidade;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;

public class RegraDiminuirChancesNotaForaDoAcorde extends RegraMelodiaMultiplicador {


	public RegraDiminuirChancesNotaForaDoAcorde() {
		super(0.5);
	}

	public RegraDiminuirChancesNotaForaDoAcorde(double multiplicador) {
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
		ListaNota acorde = musica.getAcordeInTempo(musica.getTempoPorCompasso());
		for(Probabilidade<NotaTocada> a : acao) {
			if (!acorde.contains(a.get().getNota().getNota()))
				a.multiplicarChance(multiplicador);
		}
	}

}
