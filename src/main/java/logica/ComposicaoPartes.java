package logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import entitade.Musica;
import entitade.Partes;
import entitade.escala.Escala;
import entitade.escala.Escalas;
import entitade.nota.Nota;
import entitade.nota.Som;
import implementacao.JMusic;

public class ComposicaoPartes {

	public static void main(String[] args) {
		System.setProperty("showAcorde", "true");
		final Integer tempoPorCompasso = 4;
		Integer qtdCompassos =20;
		Integer tempo = 30;
		Escala escala = Escalas.MAIOR_NATURAL.get(Nota.C);
		boolean isArpegio = false;
		Som notaBase = null;
		Som notaMelodia = null;
		boolean notasForaDaEscala = false;
		Musica musica = new Musica(escala, tempo, isArpegio, notaBase, notaMelodia,  tempoPorCompasso, qtdCompassos, notasForaDaEscala);
		
		HashMap<Partes, Musica> partes = new HashMap<Partes, Musica>();
		
		LinkedList<Partes> sequencia = new LinkedList<Partes>();
		montarSequencia(sequencia);
		
		for(Partes p : Partes.values()) {
			partes.put(p, new Musica().copyProperties(musica));
		}
		//TODO montar musica aqui
			
			sequencia.forEach(p -> musica.addParte(partes.get(p)));
			
			JMusic.render(musica);
	}

	private static void montarSequencia(LinkedList<Partes> sequencia) {
		sequencia.add(Partes.INTRO);
		sequencia.add(Partes.FRASE);
		sequencia.add(Partes.PONTE);
		sequencia.add(Partes.REFRAO);
		sequencia.add(Partes.FRASE);
		sequencia.add(Partes.FINAL);
	}
}
