package mozart;

import entitade.EscalaCigana;
import entitade.EscalaMaiorNatural;
import entitade.EscalaMenorNatural;
import entitade.Nota;

public class Testão {
	public static void main(String[] args) {
		new EscalaMaiorNatural(Nota.C).print();
		new EscalaMenorNatural(Nota.A).print();
		new EscalaCigana(Nota.C).print();
	}
}
