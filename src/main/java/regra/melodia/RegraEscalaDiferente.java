package regra.melodia;

import java.util.List;

import acao.Probabilidade;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.escala.Escalas;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;

public class RegraEscalaDiferente extends RegraMelodia {

	private Escalas escala;
	private double chanceAMultiplicar;
	private double chanceAReduzir;

	public RegraEscalaDiferente (Escalas escala, double chanceAMultiplicar, double chanceAReduzir) {
		this.escala = escala;
		this.chanceAMultiplicar = chanceAMultiplicar;
		this.chanceAReduzir = chanceAReduzir;
	}

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public Boolean executar(final List<Probabilidade<NotaTocada>> acao,
			Musica musica, Integer iteration) {

		List<Nota> notasEscala = this.escala.get(musica.getEscala().getTonica()).getNotas();
		for(Probabilidade<NotaTocada> a : acao) {
			if (notasEscala.contains(a.get().getNota().getNota())) {
				a.multiplicarChance(chanceAMultiplicar);
			} else {
				a.multiplicarChance(chanceAReduzir);
			}
		}
		super.recalcular(acao);
		return true;
	}

}
