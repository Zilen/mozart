package regra;

import java.util.List;

import acao.AcaoProcessor;
import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import regra.acorde.RegraAcorde;

public class RegraAcordeBuilder extends RegraBuilder<RegraAcorde, AcordesAcao, ListaNota> {

	private class RegraAcordeBuilderProcessor extends AcaoProcessor<AcordesAcao> {	}
	
	private Escala escala;
	private RegraAcordeBuilderProcessor processor;

	public RegraAcordeBuilder(Escala escala, RegraAcorde regra) {
		this.escala = escala;
		super.regra = regra;
		super.acoes = escala.getAcordesAcaoList();
		processor = new RegraAcordeBuilderProcessor();
		processor.atualizarChance(super.acoes);
		regra.setProcessor(processor);
	}
	
	@Override
	protected void preparar(Musica musica, Integer posicaoPrimeiro) {
		musica.getAcordes().add(escala.getAcordes().get(posicaoPrimeiro-1).getTriade());
	}

	public List<ListaNota> build() {
		return super.regraBuild().getAcordes();
	}

	@Override
	protected void recalcularProbabilidades(Integer posicao) {
		processor.atualizarChance(super.acoes);
	}
}
