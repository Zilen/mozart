package acao.melodia;

import java.util.List;
import java.util.Random;

import Utils.Rand;
import acao.Acao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;

public abstract class FraseAcao extends Acao {
	
	protected static Random random = Rand.get();

	@Override
	public void executar(Musica musica) {
		throw new RuntimeException("Método não utilizado");
	}

	public FraseAcao(double chance) {
		super(chance);
	}
	
	public abstract List<NotaTocada> executar(Musica musica, List<ListaNota> acordes, int qtdAcordes, int totalTempos);
	
	protected ListaNota getAcordeInTempo(Double tempo, List<ListaNota> acordes, Integer tempoPorCompasso) {
		return acordes.get(this.getposicaoAcorde(tempo, tempoPorCompasso)-1);
	}
	private int getposicaoAcorde(double tempo, Integer tempoPorCompasso) {
		if(tempo < tempoPorCompasso.doubleValue()) {
			return 1;
		} else {
			return 1+getposicaoAcorde(tempo-tempoPorCompasso, tempoPorCompasso);
		}
	}
}
