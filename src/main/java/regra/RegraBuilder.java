package regra;

import java.util.List;

import acao.Acao;
import entitade.Musica;

public abstract class RegraBuilder<T extends Regra<BuilderAcao>, BuilderAcao extends Acao, Retorno> {
	protected Regra<BuilderAcao> regra;
	protected List<BuilderAcao> acoes;
	protected Musica musica = new Musica();

	private void getNext(Integer iterator) {
		if (iterator.equals(0)) {
			preparar(musica, regra.getPosicaoPrimeiro());
		}
		recalcularProbabilidades(iterator);
		regra.executar(acoes, musica, iterator);
		BuilderAcao maiorProbabilidade = acoes.get(0);
		 
		 for(BuilderAcao acao : acoes) {
			 if(acao.getChance() > maiorProbabilidade.getChance()) {
				 maiorProbabilidade = acao;
			 }
		 }
		 maiorProbabilidade.executar(musica);
	}
	
	protected Musica regraBuild() {
		for(Integer iterator = 0; iterator < (regra.getQuantidadeRepeticoes()-1); iterator ++) {
			this.getNext(iterator);
		}
		return musica;
	}
	
	protected abstract void recalcularProbabilidades(Integer iterator);
	protected abstract void preparar(Musica musica, Integer posicaoPrimeiro);
}
