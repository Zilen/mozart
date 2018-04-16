package DistribuicaoNormal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class DistribuicaoNormalDuracaoTest {
	public static void main(String[] args) {
		Som nota = Som.C4;
		Nota tom = Nota.C;
		Escala escala = new EscalaMaiorNatural(tom);
		List<Probabilidade<Duracao>> probabilidadeMelodia = Duracao.gerarProbabilidades(new NotaTocada(nota, null, Duracao.FUSA), null, 1, nota, escala.getI().acorde().getTriade());
		
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
