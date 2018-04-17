package acao;

import java.util.List;

public abstract class AcaoProcessor<T extends Acao> {
	public void atualizarChance(List<T> itemAcao) {
		final double chancePadrao = 1.0 / ((Integer)itemAcao.size()).doubleValue();
		itemAcao.forEach(a -> a.atualizarChance(chancePadrao));
	}

	public void adicionarChance(int itemASetarChance, List<T> itemAcao, double chanceAAdicionar) {
		double chanceExtraida = chanceAAdicionar / (1.0 - (itemAcao.get(itemASetarChance).getChance()));
		for(T item : itemAcao) {
			if(item.equals(itemAcao.get(itemASetarChance))) {
				item.somarChance(chanceAAdicionar);
			} else {
				item.subtrairChance(item.getChance() * chanceExtraida);
			}
		}
	}
	
	public void removerChance(int itemARemoverChance, List<T> itemAcao, double chanceARemover) {
		double chanceASomar = chanceARemover/((Integer)(itemAcao.size()-1)).doubleValue();
		if(chanceARemover > itemAcao.get(itemARemoverChance).getChance()) {
			throw new RuntimeException ("chance a retirar maior que a presente");
		}
		for(T acordeAcao : itemAcao) {
			if(acordeAcao.equals(itemAcao.get(itemARemoverChance))) {
				acordeAcao.subtrairChance(chanceARemover);
			} else {
				acordeAcao.somarChance(chanceASomar);
			}
		}
	}
}
