package DistribuicaoNormal;

import java.util.Random;

import Utils.Rand;
import entitade.Duracao;
import entitade.Musica;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import implementacao.JMusic;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.View;

public class Ocarina {
	public static void main(String[] args) {
		Musica mu = new Musica(new EscalaMaiorNatural(Nota.C), 20, 4, 5);
		mu.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.C5, null, Duracao.MINIMA));
		mu.addNota(new NotaTocada(Som.DS5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.C5, null, Duracao.MINIMA));
		mu.addNota(new NotaTocada(Som.DS5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.G5, null, Duracao.COLCHEIA));

		mu.addNota(new NotaTocada(Som.AS5, null, Duracao.COLCHEIA));
		mu.addNota(new NotaTocada(Som.A5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.F5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.DS5, null, Duracao.COLCHEIA));
		mu.addNota(new NotaTocada(Som.F5, null, Duracao.COLCHEIA));
		mu.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));
		
		mu.addNota(new NotaTocada(Som.C5, null, Duracao.SEMINIMA));
		mu.addNota(new NotaTocada(Som.AS4, null, Duracao.COLCHEIA));
		mu.addNota(new NotaTocada(Som.D5, null, Duracao.COLCHEIA));
		mu.addNota(new NotaTocada(Som.C5, null, Duracao.SEMINIMA));
		
		
		JMusic.render(mu);
		
		
	}
}
