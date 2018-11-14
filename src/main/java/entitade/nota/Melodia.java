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
		throw new RuntimeException("não utilizar o add");
	}

	public void addNota(NotaTocada nota, Musica musica) {
		try {
			if(System.getProperty("showNota") != null) {
				System.out.println("Nota calculada: "+ nota.toString());
			}
			musica.updateTempoCalculadoAtual(nota.getDuracao().getDuracaoReal());
			super.add(nota);
		} catch (NullPointerException e) {
			throw e;
		}
	}
}
