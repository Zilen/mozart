package escala;

import entitade.escala.Escalas;
import entitade.nota.Nota;

public class EscalaTest {
	public static void main(String[] args) {
		for(Escalas e : Escalas.values()) {
			System.out.println(e.name());
			e.get(Nota.C).printNotas();
		}
	}
}
