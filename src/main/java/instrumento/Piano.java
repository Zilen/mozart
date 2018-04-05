package instrumento;

import java.util.List;
import java.util.Random;

import entitade.Escala;
import entitade.EscalaMaiorNatural;
import entitade.Nota;
import entitade.Som;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;

public class Piano {
	public static void main(String[] args) {

		Random random  = new Random();
		Phrase frase = new Phrase();
		Escala doMaior = new EscalaMaiorNatural(Nota.C);
		List<Som> intervalo = Som.intervalo(doMaior, Som.C5);
		
		
		for(int i = 0; i < 20; i++) {
			frase.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia().doubleValue(), 0.5));
		}
		
		
		//doMaior.getNotas().forEach(n -> n.acorde().getTriade().forEach( nota -> {
		//	
		//	Som.aleatorio(nota).getFrequencia();
		//	 
		//	frase.add(new Note(Som.aleatorio(nota).getFrequencia().doubleValue(), 0.5));
		//	
		//	
		//}));
		
		
		Play.midi(frase);

	}
}
