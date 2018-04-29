package escala;

import entitade.escala.Escalas;
import entitade.nota.Nota;

public class EscalaTest {
	public static void main(String[] args) {
		Escalas.MENOR_NATURAL.get(Nota.C).printNotas();
		Escalas.MAIOR_NATURAL.get(Nota.C).printNotas();
		Escalas.CIGANA.get(Nota.C).printNotas();
	}
}
