package acao;
import jm.music.data.Phrase;

abstract class Acao {
	
	private Double chance;

	public double getChance() {
		return chance;
	};
	
	abstract public void executar(Phrase frase);
	
	abstract public void atualizarChance(Double novaChance);
}
