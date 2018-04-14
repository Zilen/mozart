package acao.melodia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.View;

public class CromaticaAcao extends FraseAcao {

	public CromaticaAcao(double chance) {
		super(chance);
	}

	@Override
	public List<NotaTocada> executar(Musica musica, List<ListaNota> acordes, int qtdAcordes, int totalTempos) {
		
		List<Probabilidade<Som>> notasProbabilidade = new ArrayList<Probabilidade<Som>>();
		List<Probabilidade<Duracao>> duracaoProbabilidade = new ArrayList<Probabilidade<Duracao>>();
		
		
		double probabilidadeNota =  1.0 / musica.getIntervalo().size();
		List<Som> notasProximas = musica.getIntervalo().stream().filter(s -> s.getDistanciaTonal(s, musica.getNotaBaseMelodia()) < 10.0).collect(Collectors.toList());
		
		musica.getIntervalo().forEach(a-> System.out.println(""));
		
		
		
		return tocarCromatico(notasProximas, Duracao.COLCHEIA, true);
	}
	
	
	public List<NotaTocada> tocarCromatico(List<Som> notas, Duracao tempoPorNota, boolean inverso) {
		List<NotaTocada> listNotaTocada = new ArrayList<NotaTocada>();
		
		if (inverso) {
			for(int i = notas.size()-1 ;  i > 0 ; i--) {
				listNotaTocada.add(new NotaTocada(notas.get(i), null, tempoPorNota));
			}
		} else {
			for(int i = 0 ;  i < notas.size() ; i++) {
				listNotaTocada.add(new NotaTocada(notas.get(i), null, tempoPorNota));
			}
		}
		return listNotaTocada;
	}

	public static void main(String[] args) {
		CromaticaAcao c = new CromaticaAcao(25.0);
		
		List<Som> intevalo = Som.intervalo(Som.A1, Som.GS7);
		List<NotaTocada> a = c.tocarCromatico(intevalo, Duracao.SEMICOLCHEIA, true);
		a.addAll(c.tocarCromatico(intevalo, Duracao.SEMICOLCHEIA, false));
		Phrase fraseMelodia = new Phrase(0);
		a.forEach(m -> {
			fraseMelodia.add(new Note(m.getNota().getFrequencia(),  m.getDuracao().getDuracao()));
		});  
		View.show(fraseMelodia);
		Play.midi(fraseMelodia);
	}
}
