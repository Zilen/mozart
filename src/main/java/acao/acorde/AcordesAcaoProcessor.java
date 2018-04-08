package acao.acorde;

import java.util.List;
import java.util.Random;

import entitade.Musica;

public class AcordesAcaoProcessor {
	public static void calcular(Musica musica, int qtdAcordes) {
		List<AcordesAcao> acordesAcao = musica.getEscala().getAcordesAcaoList();
		Random random = new Random();
		for(int i = 0; i < qtdAcordes; i++) {
			Double chance = random.nextDouble();
			double somatoria = 0.0;
			for(AcordesAcao acao : acordesAcao) {
				somatoria += acao.getChance();
				if(chance <= somatoria) {
					acao.executar(musica);
					atualizarChance(i,acordesAcao, musica, qtdAcordes);
					break;
				}
			}
			
		}
	}

	private static void atualizarChance(int i, List<AcordesAcao> acordesAcao, Musica musica, int qtdAcordes) {
		if(acordesAcao.get(i).getChance().equals(1.0)) {
			acordesAcao.forEach(a -> a.atualizarChance(1.0 / 7.0));
		}
	}
	
	private static void acionarChance(int acordeASetarChance, List<AcordesAcao> acordesAcao, double chanceAAdicionar) {
		double chanceExtraida = chanceAAdicionar / (1.0 - (acordesAcao.get(acordeASetarChance).getChance()));
		for(AcordesAcao acordeAcao : acordesAcao) {
			if(acordeAcao.equals(acordesAcao.get(acordeASetarChance))) {
				acordeAcao.somarChance(chanceAAdicionar);
			} else {
				acordeAcao.subtrairChance(acordeAcao.getChance() * chanceExtraida);
			}
		}
	}

}
