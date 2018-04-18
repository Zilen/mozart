package DistribuicaoNormal;

import entitade.Duracao;
import entitade.Musica;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import implementacao.JMusic;

public class Ocarina {
	public static void main(String[] args) {
		Musica m = new Musica(new EscalaMaiorNatural(Nota.C), 20, 4, 5);
		m.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.C5, null, Duracao.MINIMA));
		m.addNota(new NotaTocada(Som.DS5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.C5, null, Duracao.MINIMA));
		m.addNota(new NotaTocada(Som.DS5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.G5, null, Duracao.COLCHEIA));

		m.addNota(new NotaTocada(Som.AS5, null, Duracao.COLCHEIA));
		m.addNota(new NotaTocada(Som.A5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.F5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.DS5, null, Duracao.COLCHEIA));
		m.addNota(new NotaTocada(Som.F5, null, Duracao.COLCHEIA));
		m.addNota(new NotaTocada(Som.G5, null, Duracao.SEMINIMA));

		m.addNota(new NotaTocada(Som.C5, null, Duracao.SEMINIMA));
		m.addNota(new NotaTocada(Som.AS4, null, Duracao.COLCHEIA));
		m.addNota(new NotaTocada(Som.D5, null, Duracao.COLCHEIA));
		m.addNota(new NotaTocada(Som.C5, null, Duracao.SEMINIMA));
		
		
		JMusic.render(m);
	}
}
