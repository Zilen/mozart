package regra.melodia;

import java.util.List;

import acao.melodia.FraseAcao;
import entitade.Musica;

public class RegraNovoAcordeNovaNota extends RegraMelodia {

	@Override
	public Boolean isValid(List<FraseAcao> acao, Musica musica, Integer iteration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executar(List<FraseAcao> acao, Musica musica, Integer iteration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPosicaoPrimeiro() {
		return null;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return 2;
	}

}
