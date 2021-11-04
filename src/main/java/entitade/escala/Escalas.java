package entitade.escala;

import java.lang.reflect.InvocationTargetException;

import entitade.nota.Nota;

public enum Escalas {
	CIGANA(EscalaCigana.class),
	HIRAJOSHI_SACHS(EscalaHirajoshiSachs.class),
	HIRAJOSHI_BURROWS(EscalaHirajoshiBurrows.class),
	ARABICA_MAIOR(EscalaArabeMaior.class),
	ARABICA_MENOR(EscalaArabeMenor.class),
	MENOR_NATURAL(EscalaMenorNatural.class),
	MAIOR_NATURAL(EscalaMaiorNatural.class),
	MENOR_HARMONICA(EscalaMenorHarmonica.class),
	MAIOR_HARMONICA(EscalaMaiorHarmonica.class),;
	
	private Class clazz;

	private Escalas(Class c) {
		this.clazz = c;
	}
	
	public Escala get(Nota n) {
		Escala escala = null;
		try {
			escala = (Escala) this.clazz.getConstructor(Nota.class).newInstance(n);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			System.out.println("escala sem construtor!");
			e.printStackTrace();
		}
		return escala;
	}
	
}
