package regra;

import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;

public interface Regra {
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, final Integer iteration);
	public void executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration);
}
