package entitade.nota;

import java.util.ArrayList;

import entitade.Musica;

public class Melodia extends ArrayList<NotaTocada> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -831696275500891598L;

	@Override
	@Deprecated
	public boolean add(NotaTocada notaTocada) {
		return false;
	}
	
	public void addNota(NotaTocada nota, Musica musica) {
		musica.updateTempoCalculadoAtual(nota.getDuracao().getDuracaoReal());
		super.add(nota);
	}
}
