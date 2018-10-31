package regra.acorde;

import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;

public class RegraDiminuirChance7 extends RegraAcorde {

	private Escala nomeEscala = new EscalaMaiorNatural(null);
	
	@Override
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		
		return musica.getEscala().getNome().equals(nomeEscala.getNome());
	}

	@Override
	public void executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
			processor.removerChance(0, acordesAcao, acordesAcao.get(0).getChance() * 0.70);
		}

	@Override
	public Integer getPosicaoPrimeiro() {
		return null;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return 1;
	}
}
