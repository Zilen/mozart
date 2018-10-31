package regra;

import java.util.List;

import entitade.Musica;

public interface Regra<TipoAcao> {
	public Boolean isValid(List<TipoAcao> acao, Musica musica, final Integer iteration);
	public void executar(List<TipoAcao> acao, Musica musica, Integer iteration);
	public abstract Integer getPosicaoPrimeiro();
	public abstract Integer getQuantidadeRepeticoes();
}
