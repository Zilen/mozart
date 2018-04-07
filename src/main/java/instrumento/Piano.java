package instrumento;

import java.util.Arrays;
import java.util.Iterator;
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
import jm.util.View;

public class Piano {
	public static void main(String[] args) {

		Part part = new Part();
		part.setTempo(40);
		Random random  = new Random();
		Phrase fraseMelodia = new Phrase(0);
		Escala doMaior = new EscalaMaiorNatural(Nota.D);
		List<Som> intervalo = Som.intervalo(doMaior, Som.C5);
		List<Som> intervaloBase = Som.intervalo(doMaior, Som.B2, Som.C4);
		
		
//		for(int i = 0; i < 20; i++) {
//			fraseMelodia.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia(),  0.5));
//			
//		}
		
		fraseMelodia.addNoteList(montarArpegio(doMaior.getVI().acorde().getTriade(), intervaloBase));
		fraseMelodia.addNoteList(montarArpegio(doMaior.getIV().acorde().getTriade(), intervaloBase));
		fraseMelodia.addNoteList(montarArpegio(doMaior.getI().acorde().getTriade(), intervaloBase));
		fraseMelodia.addNoteList(montarArpegio(doMaior.getV().acorde().getTriade(), intervaloBase));
		
		
		CPhrase cphraseAcordes = new CPhrase(0);
//		doMaior.getAcordes().forEach(a-> {
//		cphraseAcordes.addChord(montarAcorde(a.getTriade(), intervaloBase));
//		});
		
		for(int i =0; i<2; i++) {
//			cphraseAcordes.addChord(montarAcorde(doMaior.getI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getVI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getIV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getVI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getIV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getV().acorde().getSetima(), intervaloBase));
		}
		
		
		Phrase frase2 = new Phrase(0);
		for(int i = 0; i < 20; i++) {
			frase2.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia(), 0.5));
		}
		part.add(fraseMelodia);
		part.addCPhrase(cphraseAcordes);
		View.show(part);
		Play.midi(part);
		
	}
	private static int montarAcordeIterator =0;
	private static Note[] montarAcorde(ListaNota acorde, List<Som> intervalo) {
		System.out.println(acorde.getNome());
		Note[] notas = new Note[acorde.size()];
		for(montarAcordeIterator=0; montarAcordeIterator < acorde.size(); montarAcordeIterator++) {
			notas[montarAcordeIterator] = new Note(intervalo.stream().filter(n -> n.getNota().equals(acorde.get(montarAcordeIterator))).findFirst().get().getPitch(), Duracao.SEMIBREVE.getDuracao());
		}
		return notas;
	}
	private static Note[] montarArpegio(ListaNota acorde, List<Som> intervalo) {
		System.out.println(acorde.getNome());
		Note[] notas = new Note[acorde.size()];
		Som inicial = intervalo.get(0);
		boolean iniciar = Boolean.FALSE;
		Iterator<Nota> acordeIterator = acorde.iterator();
		Nota nota = acordeIterator.next();
		int notaPosicao = 0;
		for(Som s : Som.values()) {
			if (iniciar) {
				if (s.getNota().equals(nota)) {
					notas[notaPosicao++] = new Note(s.getFrequencia(), Duracao.MINIMA.getDuracao());
					if(acordeIterator.hasNext()) {
						nota = acordeIterator.next();
					} else {
						break;
					}
				}
			} else {
				if (s.equals(inicial)) {
					iniciar = Boolean.TRUE;
				}
			}
		}
		return notas;
	}
}
