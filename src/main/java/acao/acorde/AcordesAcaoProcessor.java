package acao.acorde;

import java.util.List;
import java.util.Random;

import Utils.Rand;
import entitade.Musica;
import regra.acorde.RegraAcorde;

public class AcordesAcaoProcessor {
	
	
	public List<RegraAcorde> regras;
	
	public AcordesAcaoProcessor(List<RegraAcorde> regras) {
		this.regras = regras;
		if (regras != null) {
			this.regras.forEach(r -> r.setProcessor(this));
		}
	}
	
	public void calcular(Musica musica) {
		List<AcordesAcao> acordesAcao = musica.getEscala().getAcordesAcaoList();
		Random random = Rand.get();
		for(int i = 0; i < musica.getQtdCompassos(); i++) {
			for(RegraAcorde r : this.regras) {
				if(r.isValid(acordesAcao, musica, i)) {
					r.executar(acordesAcao, musica, i);
					System.out.println("executando regra: "+r.getClass().getName());
				}
			}
			Double chance = random.nextDouble();
			double somatoria = 0.0;
			int posicao = 0;
			for(AcordesAcao acao : acordesAcao) {
				somatoria += acao.getChance();
				if(chance <= somatoria) {
					acao.executar(musica);
//					atualizarChance(posicao++,acordesAcao, musica, qtdAcordes);
					atualizarChance(acordesAcao);
					break;
				}
				posicao++;
			}
//			System.out.println("chances:");
//			acordesAcao.forEach(a -> System.out.println(a.getChance()));
//			System.out.println("chances fim");
		}
	}

//	public void atualizarChance(int i, List<AcordesAcao> acordesAcao, Musica musica, int qtdAcordes) {
//			this.removerChance(i, acordesAcao, (acordesAcao.get(i).getChance() / 7.0) * 6.0);
//	}
	
	private void atualizarChance(List<AcordesAcao> acordesAcao) {
		final double chancePadrao = 1.0 / 7.0;
		acordesAcao.forEach(a -> a.atualizarChance(chancePadrao));
	}

	public void adicionarChance(int acordeASetarChance, List<AcordesAcao> acordesAcao, double chanceAAdicionar) {
		double chanceExtraida = chanceAAdicionar / (1.0 - (acordesAcao.get(acordeASetarChance).getChance()));
		for(AcordesAcao acordeAcao : acordesAcao) {
			if(acordeAcao.equals(acordesAcao.get(acordeASetarChance))) {
				acordeAcao.somarChance(chanceAAdicionar);
			} else {
				acordeAcao.subtrairChance(acordeAcao.getChance() * chanceExtraida);
			}
		}
	}
	
	public void removerChance(int acordeARemoverChance, List<AcordesAcao> acordesAcao, double chanceARemover) {
		double chanceASomar = chanceARemover/6.0;
		if(chanceARemover > acordesAcao.get(acordeARemoverChance).getChance()) {
			throw new RuntimeException ("chance a retirar maior que a presente");
		}
		for(AcordesAcao acordeAcao : acordesAcao) {
			if(acordeAcao.equals(acordesAcao.get(acordeARemoverChance))) {
				acordeAcao.subtrairChance(chanceARemover);
			} else {
				acordeAcao.somarChance(chanceASomar);
			}
		}
	}

}
