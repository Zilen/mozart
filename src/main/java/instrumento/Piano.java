package instrumento;

import java.util.List;
import java.util.Random;

import entitade.Escala;
import entitade.EscalaMaiorNatural;
import entitade.Nota;
import entitade.Som;
import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.util.Play;

public class Piano {
	public static void main(String[] args) {

		Random random  = new Random();
		Phrase frase = new Phrase(0);
		Escala doMaior = new EscalaMaiorNatural(Nota.C);
		List<Som> intervalo = Som.intervalo(doMaior, Som.C5);
		
		
		for(int i = 0; i < 20; i++) {
			frase.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia(), 0.5));
		}
		
		
		CPhrase cphrase = new CPhrase(0);
		cphrase.addChord(new Note[] {new Note(Som.C3.getFrequencia(), 1), new Note(Som.E3.getFrequencia(), 1), new Note(Som.G3.getFrequencia(), 1)});
		cphrase.addChord(new Note[] {new Note(Som.G3.getFrequencia(), 1), new Note(Som.B3.getFrequencia(), 1), new Note(Som.E4.getFrequencia(), 1)});
		cphrase.addChord(new Note[] {new Note(Som.G3.getFrequencia(), 1), new Note(Som.B3.getFrequencia(), 1), new Note(Som.E4.getFrequencia(), 1)});
		cphrase.addChord(new Note[] {new Note(Som.G3.getFrequencia(), 1), new Note(Som.B3.getFrequencia(), 1), new Note(Som.E4.getFrequencia(), 1)});
		
		//doMaior.getNotas().forEach(n -> n.acorde().getTriade().forEach( nota -> {
		//	
		//	Som.aleatorio(nota).getFrequencia();
		//	 
		//	frase.add(new Note(Som.aleatorio(nota).getFrequencia().doubleValue(), 0.5));
		//	
		//	
		//}));
//		frase.addChord(pitches, rv);(cphrase);
		
		
		Phrase frase2 = new Phrase(0);
		for(int i = 0; i < 20; i++) {
			frase2.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia(), 0.5));
		}
		Part part = new Part();
		part.add(frase);
		part.addCPhrase(cphrase);
		Play.midi(part);

	}
}
