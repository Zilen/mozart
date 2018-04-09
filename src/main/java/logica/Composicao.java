package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acao.acorde.AcordesAcaoProcessor;
import entitade.Duracao;
import entitade.Intensidade;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import entitade.nota.NotaTocada;
import implementacao.JMusic;
import regra.acorde.Regra1564;
import regra.acorde.Regra251;
import regra.acorde.Regra6415;
import regra.acorde.Regra71;
import regra.acorde.RegraAcorde;

public class Composicao {
	
	public static void main(String[] args) {
		new Composicao(new EscalaMaiorNatural(Nota.C)).compor().renderizar();
//		new Composicao(new EscalaMenorNatural(Nota.Ds)).compor().renderizar();
	}
	
	
	private Musica musica;
	Random random;
	
	public Composicao(Escala escala) {
		musica = new Musica(escala, 40, true);
		random = new Random();
	}
	
	//compor musica;
	public Composicao compor() {
		comporAcordes(17);
//		comporMelodia(16);
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
		List<RegraAcorde> regras = new ArrayList<RegraAcorde>();
		regras.add(new Regra251());
		regras.add(new Regra6415());
		regras.add(new Regra1564());
		regras.add(new Regra71());
		new AcordesAcaoProcessor(regras).calcular(musica, qtdAcordes);
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
