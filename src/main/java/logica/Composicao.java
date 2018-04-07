package logica;

import java.util.ArrayList;
import java.util.Random;

import entitade.Duracao;
import entitade.Intensidade;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import implementacao.JMusic;

public class Composicao {
	
	public static void main(String[] args) {
		Composicao c = new Composicao(new EscalaMaiorNatural(Nota.C));
		c.compor();
		c.renderizar();
	}
	
	
	private Musica musica;
	Random random;
	
	public Composicao(Escala escala) {
		musica = new Musica(escala, 120);
		random = new Random();
	}
	
	//compor musica;
	public void compor() {
		ArrayList<NotaTocada> notas = new ArrayList<NotaTocada>();
		for(int i = 0; i < 10; i++) {
			notas.add(new NotaTocada(musica.getIntervalo().get(random.nextInt(musica.getIntervalo().size())), Intensidade.FF, Duracao.MINIMA));
		}
		musica.addNotas(notas);
		
		musica.addAcode(musica.getEscala().getVI().acorde().getTriade());
		musica.addAcode(musica.getEscala().getIV().acorde().getTriade());
		musica.addAcode(musica.getEscala().getI().acorde().getTriade());
		musica.addAcode(musica.getEscala().getV().acorde().getTriade());
	}
	
	
	//rederizar;
	public void renderizar() {
		JMusic.render(this.musica);
	}
}
