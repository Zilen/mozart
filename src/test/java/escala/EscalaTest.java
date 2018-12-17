package escala;

import entitade.escala.Escalas;
import entitade.nota.Nota;

public class EscalaTest {
	public static void main(String[] args) {

		Nota n = Nota.A;

		for(Escalas e : Escalas.values()) {
			System.out.print(e.name() + " - ");
			e.get(n).printNotas();
		}
	}
}
