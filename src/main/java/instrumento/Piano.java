package instrumento;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Utils.Rand;
import entitade.Duracao;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.Som;
import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.View;

public class Piano {
	public static void main(String[] args) {

		Part part = new Part();
		part.setTempo(120);
		Random random  = Rand.get();
		Phrase fraseMelodia = new Phrase(0);
		Escala doMaior = new EscalaMaiorNatural(Nota.D);
		List<Som> intervalo = Som.intervalo(doMaior, Som.C5);
		List<Som> intervaloBase = Som.intervalo(doMaior, Som.B2, Som.C4);
		
		
		for(int i = 0; i < 20; i++) {
			fraseMelodia.add(new Note(intervalo.get(random.nextInt(intervalo.size())).getFrequencia(),  0.5));
		}
			
		CPhrase cphraseAcordes = new CPhrase(0);
//		doMaior.getAcordes().forEach(a-> {
//		cphraseAcordes.addChord(montarAcorde(a.getTriade(), intervaloBase));
//		});
		
		Phrase f = new Phrase(0);
		for(int i =0; i<2; i++) {
//			cphraseAcordes.addChord(montarAcorde(doMaior.getI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getVI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getIV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getVI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getIV().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getI().acorde().getTriade(), intervaloBase));
//			cphraseAcordes.addChord(montarAcorde(doMaior.getV().acorde().getSetima(), intervaloBase));
			
			
			f.addNoteList(montarArpegio(doMaior.getVI().getAcorde().getTriade(), intervaloBase));
			f.addNoteList(montarArpegio(doMaior.getIV().getAcorde().getTriade(), intervaloBase));
			f.addNoteList(montarArpegio(doMaior.getI().getAcorde().getTriade(), intervaloBase));
			f.addNoteList(montarArpegio(doMaior.getV().getAcorde().getTriade(), intervaloBase));
			
			

		}
		cphraseAcordes.addPhrase(f);
		
		
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
		Note[] notas = new Note[acorde.size()+1];
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
						notas[notaPosicao++] = notas[notaPosicao-3];
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
