package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Utils.Rand;
import acao.acorde.AcordesAcaoProcessor;
import acao.melodia.MelodiaAcaoProcessor;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.Escalas;
import entitade.nota.Nota;
import implementacao.JMusic;
import regra.acorde.Regra1564;
import regra.acorde.Regra1637;
import regra.acorde.Regra251;
import regra.acorde.Regra71;
import regra.acorde.RegraAcorde;
import regra.acorde.RegraDiminuirChance7;
import regra.acorde.RegraDiminuirChanceAcordeRepetido;

public class Composicao {

	public static void main(String[] args) {
		System.setProperty("showAcorde", "true");
		final Integer tempoPorCompasso = 4;
		Integer qtdCompassos =10;
		Integer tempo = 20;
		new Composicao(Escalas.MAIOR_NATURAL.get(Nota.C), tempoPorCompasso, qtdCompassos, tempo).compor().renderizar();
	}


	private Musica musica;
	Random random;

//	public Composicao(Escala escala, Integer tempo, boolean isArpegio, Som notaBase, Som notaMelodia,  Integer tempoPorCompasso, Integer qtdCompassos, boolean notasForaDaEscala) {
//		musica = new Musica(escala, tempo, isArpegio, notaBase, notaMelodia, tempoPorCompasso, qtdCompassos, notasForaDaEscala);
//		random = Rand.get();
//	}

	public Composicao(Escala escala, Integer tempoPorCompasso, Integer qtdCompassos, Integer tempo) {
		musica = new Musica(escala, tempo, false, tempoPorCompasso, qtdCompassos, false);
		random = Rand.get();
	}

//	public Composicao(Musica musica) {
//		this.musica = musica;
//		random = Rand.get();
//	}

	//compor musica;
	public Composicao compor() {
		comporAcordes();
		comporMelodia();
		return this;
	}

	private void comporMelodia() {
		System.out.println("Compondo Melodia");
		new MelodiaAcaoProcessor(null).calcular(musica);
	}

	private void comporAcordes() {
		System.out.println("Compondo Acordes");
		List<RegraAcorde> regras = new ArrayList<RegraAcorde>();
		regras.add(new RegraDiminuirChance7());
		regras.add(new Regra251());
		regras.add(new Regra1637());
		regras.add(new Regra1564());
		regras.add(new Regra71());
		regras.add(new RegraDiminuirChanceAcordeRepetido());
		new AcordesAcaoProcessor(regras).calcular(musica);
		
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
