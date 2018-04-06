package instrumento;

import java.util.List;
import java.util.Random;

import entitade.Duracao;
import entitade.Escala;
import entitade.EscalaMaiorNatural;
import entitade.ListaNota;
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
		List<Som> intervaloBase = Som.intervalo(doMaior, Som.C2);
		
		
		for(int i = 0; i < 20; i++) {
//			frase.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequenciaDouble(), 0.5));
		}
		
		
		CPhrase cphrase = new CPhrase(0);
		doMaior.getAcordes().forEach(a-> {
		
		cphrase.addChord(montarAcorde(a.getTriade(), intervaloBase));
		
		
		});
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
			frase2.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequenciaDouble(), 0.5));
		}
		Part part = new Part();
		part.add(frase);
		part.addCPhrase(cphrase);
		Play.midi(part);

	}
	private static int montarAcordeIterator =0;
	private static Note[] montarAcorde(ListaNota acorde, List<Som> intervalo) {
		Note[] notas = new Note[acorde.size()];
		for(montarAcordeIterator=0; montarAcordeIterator < acorde.size(); montarAcordeIterator++) {
			notas[montarAcordeIterator] = new Note(intervalo.stream().filter(n -> n.getNota().equals(acorde.get(montarAcordeIterator))).findFirst().get().getFrequenciaInt(), Duracao.SEMIBREVE.getDuracao());
		}
		
		return notas;
	}
}
