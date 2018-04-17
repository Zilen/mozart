package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Utils.Rand;
import acao.acorde.AcordesAcaoProcessor;
import acao.melodia.MelodiaAcaoProcessor;
import entitade.Musica;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;
import implementacao.JMusic;
import regra.acorde.Regra1564;
import regra.acorde.Regra1637;
import regra.acorde.Regra251;
import regra.acorde.Regra71;
import regra.acorde.RegraAcorde;
import regra.acorde.RegraDiminuirChance7;

public class Composicao {
	
	public static void main(String[] args) {
		final Integer tempoPorCompasso = 4;
		Integer qtdCompassos =20;
		new Composicao(new EscalaMaiorNatural(Nota.C), tempoPorCompasso, qtdCompassos).compor().renderizar();
//		new Composicao(new EscalaMenorNatural(Nota.Ds)).compor().renderizar();
	}
	
	
	private Musica musica;
	Random random;
	
	public Composicao(Escala escala, Integer tempoPorCompasso, Integer qtdCompassos) {
		musica = new Musica(escala, 20, false, tempoPorCompasso, qtdCompassos, false);
		random = Rand.get();
	}
	
	//compor musica;
	public Composicao compor() {
		comporAcordes(musica.getQtdCompassos());
		comporMelodia();
		return this;
		
	}

	private void comporMelodia() {
		System.out.println("Compondo Melodia");
		new MelodiaAcaoProcessor(null).calcular(musica);
	}

	private void comporAcordes(int qtdAcordes) {
		System.out.println("Compondo Acordes");
		List<RegraAcorde> regras = new ArrayList<RegraAcorde>();
		regras.add(new RegraDiminuirChance7());
		regras.add(new Regra251());
		regras.add(new Regra1637());
		regras.add(new Regra1564());
		regras.add(new Regra71());
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
