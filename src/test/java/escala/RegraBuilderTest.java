package escala;

import entitade.escala.Escalas;
import entitade.nota.Nota;
import regra.RegraAcordeBuilder;
import regra.acorde.Regra1564;
import regra.acorde.Regra1637;

public class RegraBuilderTest {
	public static void main(String[] args) {
		

		System.out.println("----------");
		new RegraAcordeBuilder(Escalas.MAIOR_NATURAL.get(Nota.C), new Regra1564()).build().forEach(l -> System.out.println(l.getNome()));
		
		System.out.println("----------");
		new RegraAcordeBuilder(Escalas.MENOR_NATURAL.get(Nota.A), new Regra1637()).build().forEach(l -> System.out.println(l.getNome()));
		
		System.out.println("----------");
	}
}
