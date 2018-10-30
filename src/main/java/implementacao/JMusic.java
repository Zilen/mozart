package implementacao;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Utils.Rand;
import entitade.Duracao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.Nota;
import entitade.nota.Som;
import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.View;

public class JMusic {
	public static void render(Musica musica) {

		Part part = new Part();
		part.setTempo(musica.getTempo());
		Random random  = Rand.get();
		Phrase fraseMelodia = new Phrase(0);
		List<Som> intervalo = Som.intervalo(musica.getEscala(), musica.getNotaBaseMelodia());
		List<Som> intervaloBase = Som.intervalo(musica.getEscala(), musica.getNotaBaseBaixo(), musica.getNotaBaseMelodia());

		//melodia
		musica.getMelodia().forEach(m -> {

			if((m.getNota().equals(Som.PAUSA))) {
				fraseMelodia.add(new Note(Integer.MIN_VALUE,  m.getDuracao().getDuracao()));
			} else {
				fraseMelodia.add(new Note(m.getNota().getFrequencia(),  m.getDuracao().getDuracao()));
			}
		});

		CPhrase cphraseAcordes = new CPhrase(0);

		//acordes
		if(musica.isArpegio()) {
			Phrase f = new Phrase(0);
			musica.getAcordes().forEach(a-> {
				f.addNoteList(montarArpegio(a, intervaloBase));
			});
			cphraseAcordes.addPhrase(f);
		} else {
			musica.getAcordes().forEach(a-> {
				cphraseAcordes.addChord(montarAcorde(a , intervaloBase, musica.getTempoPorCompasso()));
			});
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

	private static int montarAcordeIterator = 0;
	private static Note[] montarAcorde(ListaNota acorde, List<Som> intervalo, Integer tempoPorAcorde) {
//		System.out.println(acorde.getNome());
		Note[] notas = new Note[acorde.size()];
		Duracao d = getDuracaoPorTempo(tempoPorAcorde);
		for(montarAcordeIterator=0; montarAcordeIterator < acorde.size(); montarAcordeIterator++) {
			notas[montarAcordeIterator] = new Note(intervalo.stream().filter(n -> n.getNota().equals(acorde.get(montarAcordeIterator))).findFirst().get().getPitch(), d.getDuracao());
		}
		montarAcordeIterator = 0;
		return notas;
	}
	private static Duracao getDuracaoPorTempo(Integer tempoPorAcorde) {
		Duracao retorno = null;
		for(Duracao d : Duracao.values()) {
			Double duracaoCalculada = d.getDuracao() * 4.0;
			if(duracaoCalculada.equals(tempoPorAcorde.doubleValue())) {
				retorno = d;
				break;
			}
		}
		return retorno;
	}
	private static Note[] montarArpegio(ListaNota acorde, List<Som> intervalo) {
//		System.out.println(acorde.getNome());
		Note[] notas = new Note[acorde.size()+1];
		Som inicial = intervalo.get(0);
		boolean iniciar = Boolean.FALSE;
		Iterator<Nota> acordeIterator = acorde.iterator();
		Nota nota = acordeIterator.next();
		int notaPosicao = 0;
		for(Som s : Som.values()) {
			if (iniciar) {
				if (s.getNota().equals(nota)) {
					notas[notaPosicao++] = new Note(s.getFrequencia(), Duracao.SEMINIMA.getDuracao());
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
