package regra.acorde;

import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.acorde.ListaNota;

public class RegraDiminuirChanceAcordeRepetido extends RegraAcorde {

	@Override
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {

		return iteration > 0;
	}

	@Override
	public Boolean executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {


		ListaNota ultimoAcorde = musica.getAcordes().get(iteration -1);

		int valorUltimoAcorde = ultimoAcorde.getAcorde().getPosicaoEscala() -1;

		processor.removerChance(valorUltimoAcorde, acordesAcao, acordesAcao.get(valorUltimoAcorde).getChance() * 0.70);

		return false;
	}

	@Override
	public Integer getPosicaoPrimeiro() {
		return null;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return null;
	}
}
