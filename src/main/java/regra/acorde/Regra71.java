package regra.acorde;

import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.acorde.ListaNota;

public class Regra71 extends RegraAcorde {



	@Override
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {

		ListaNota a = musica.getAcordes().size() >= 1 ? musica.getAcordes().get(musica.getAcordes().size() -1) : null;
		boolean is71 = this.consume(a);

		return is71;
	}

	private Boolean consume(ListaNota a) {
		boolean retorno = false;
		if(a != null && a.getPosicaoEscala().equals(7)) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public Boolean executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		ListaNota acordeAnterior = musica.getAcordes().get(musica.getAcordes().size()-1);
		if(acordeAnterior.getPosicaoEscala().equals(7)) {
			processor.adicionarChance(0, acordesAcao, acordesAcao.get(0).getChanceInversa() * 0.20);
		}
		return false;
	}

	@Override
	public Integer getPosicaoPrimeiro() {
		return 7;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return 2;
	}

}
