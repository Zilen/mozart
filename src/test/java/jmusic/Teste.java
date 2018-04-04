package jmusic;

import java.util.List;

import entitade.Acorde;
import entitade.EscalaCigana;
import entitade.EscalaMaiorNatural;
import entitade.EscalaMenorNatural;
import entitade.Nota;

public class Teste {
	public static void main(String[] args) {
		testEscalas();
		testAcordes();
	}
	
	private static void testEscalas() {
		System.out.println("testEscalas");
//		new EscalaMaiorNatural(Nota.C).printNotas();
//		new EscalaMenorNatural(Nota.A).printNotas();
		new EscalaCigana(Nota.C).printNotas();
	}
	
	private static void testAcordes() {
		System.out.println("testAcordes");
		List<Acorde> acordes = new EscalaMaiorNatural(Nota.C).getAcordes();
		acordes.forEach(
				a -> {
					System.out.println(a.getSus().getNome());
//					System.out.print("----");
//					a.getDecimaTerceira().forEach(n -> {System.out.print(n.getNome() + " "); });
//					System.out.print("----");
				}
				);
	}
}
