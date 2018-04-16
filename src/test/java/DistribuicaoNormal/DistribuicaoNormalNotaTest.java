package DistribuicaoNormal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import acao.Probabilidade;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.Som;
import math.DistribuicaoNormal;

public class DistribuicaoNormalNotaTest {
	public static void main(String[] args) {
		Som nota = Som.C4;
		Nota tom = Nota.C;
		Escala escala = new EscalaMaiorNatural(tom);
		List<Som> intervalo = Som.intervalo(escala, nota);
		List<Som> intervaloCromatico = Som.intervalo(intervalo.get(0), intervalo.get(intervalo.size() - 1));
		List<Probabilidade<Som>> probabilidadeMelodia = Som.gerarProbabilidades(intervalo, intervaloCromatico, nota, escala, escala.getIV().acorde().getTriade());
		
		probabilidadeMelodia.forEach(p -> 
		{
			System.out.println(p.get()+"@"+round(p.getChance(),4));	
		});
//		
//		System.out.println("--------");
//		
//		for (Double i = 25.0; i < 50; i++) {
//			System.out.println(i+"@"+round(DistribuicaoNormal.getY(i, 38.0, 0.9), 4));
//		}
		
	}
	
	public static String round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.toString().replace(".", ",");
	}
}
