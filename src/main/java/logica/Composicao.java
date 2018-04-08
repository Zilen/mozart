package logica;

import java.util.ArrayList;
import java.util.Random;

import acao.acorde.AcordesAcaoProcessor;
import entitade.Duracao;
import entitade.Intensidade;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.EscalaMenorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import implementacao.JMusic;

public class Composicao {
	
	public static void main(String[] args) {
//		new Composicao(new EscalaMaiorNatural(Nota.C)).compor().renderizar();
		new Composicao(new EscalaMenorNatural(Nota.Ds)).compor().renderizar();
	}
	
	
	private Musica musica;
	Random random;
	
	public Composicao(Escala escala) {
		musica = new Musica(escala, 40, true);
		random = new Random();
	}
	
	//compor musica;
	public Composicao compor() {
		comporAcordes(7);
		comporMelodia(16);
		return this;
		
	}

	private void comporMelodia(int tempos) {
		ArrayList<NotaTocada> notas = new ArrayList<NotaTocada>();
		for(int i = 0; i < tempos; i++) {
			notas.add(new NotaTocada(musica.getIntervalo().get(random.nextInt(musica.getIntervalo().size())), Intensidade.FF, Duracao.SEMINIMA));
		}
		musica.addNotas(notas);
	}

	private void comporAcordes(int qtdAcordes) {
		AcordesAcaoProcessor.calcular(musica, qtdAcordes);
//		musica.addAcode(musica.getEscala().getVI().acorde().getTriade());
//		musica.addAcode(musica.getEscala().getIV().acorde().getTriade());
//		musica.addAcode(musica.getEscala().getI().acorde().getTriade());
//		musica.addAcode(musica.getEscala().getV().acorde().getTriade());
	}
	
	
	//rederizar;
	public Composicao renderizar() {
		JMusic.render(this.musica);
		return this;
	}
}
