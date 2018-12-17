package regra.melodia;

import java.util.List;

import acao.Probabilidade;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;

public class RegraSomenteTriade extends RegraMelodia {

	@Override
	public Boolean isValid(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration) {
		return true;
	}

	@Override
	public Boolean executar(final List<Probabilidade<NotaTocada>> acao,
			Musica musica, Integer iteration) {
		ListaNota acorde = musica.getAcordeInTempo(musica.getTempoCalculadoAtual());
		for(Probabilidade<NotaTocada> a : acao) {
			if (acorde.contains(a.get().getNota().getNota())) {
				a.multiplicarChance(0.01);
			} else {
				a.multiplicarChance(0.0);
			}
		}
		super.recalcular(acao);
		return true;
	}

}
