package math;

import java.util.List;

import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.Som;

public class DistribuicaoNormal {
	public static Double getY(Double x, Double m, Double s) {
		double pi = Math.PI;
		double e = Math.E;
		s = 1.0;
		Double parte1 = (1.0 / (Math.sqrt(2*pi) * s))*e;
		
		Double parte2 =  (- Math.pow((x - m), 2)) / (2* Math.pow(s, 2));
		
		return Math.pow(parte1, parte2) *40;
	}
	
	
	public static void main(String[] args) {
		
//		List<Som> intervalo = Som.intervalo(Som.D3, Som.D5);
		List<Som> intervalo = Som.intervalo(new EscalaMaiorNatural(Nota.D),Som.D3, Som.D5);
		Som.mapProbabilidade(intervalo, Som.D4, new EscalaMaiorNatural(Nota.D)).forEach((a,b) -> System.out.println(a.getFrequencia().toString().replace(".", ",")+"@"+b.toString().replace(".", ",")));
		
		//		for(Double i = 0.0; i < 10.0; i++) {
//			System.out.println(i.toString().replace(".", ",")+"@"+getY(i, 4.2, 0.8).toString().replace(".", ","));
//		}
	}

}
