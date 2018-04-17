package acao.melodia;

import java.util.ArrayList;
import java.util.List;

import Utils.Rand;
import acao.Acao;
import entitade.Duracao;
import entitade.Intensidade;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class FraseComposer {
	private List<Acao> acoes;
	
	public FraseComposer(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	public void compor(List<ListaNota> acordes, int qtdAcordes, Musica musica) {
		Double tempos = ((Integer)(musica.getTempoPorCompasso() * qtdAcordes)).doubleValue();
		Double tempo = 0.0;
		do {
			ListaNota acorde = getAcordeInTempo(tempo, acordes, musica.getTempoPorCompasso());
			
		} while (tempo < tempos);
		
		
//		Duracao[] duracoes = Duracao.values();
//		ArrayList<NotaTocada> notas = new ArrayList<NotaTocada>();
//		while (tempo < musica.getTempoPorCompasso() * musica.getQtdCompassos()) {
//			Duracao tempoCalculado = duracoes[Rand.between(0, duracoes.length -1)];
//			tempo += tempoCalculado.getDuracao() *4.0;
//			ListaNota acordeCompasso = musica.getAcordeInTempo(tempoCalculado.getDuracao());
//			Som notaTocada = null;
//			do {
//				notaTocada = musica.getIntervalo().get(Rand.nextInt(musica.getIntervalo().size()));
//			} while (naoPertenceAoAcorde(acordeCompasso, notaTocada));
//			
//			notas.add(new NotaTocada(notaTocada, Intensidade.FF, tempoCalculado));
//		}
//		musica.addNotas(notas);
	}
	
	private ListaNota getAcordeInTempo(Double tempo, List<ListaNota> acordes, Integer tempoPorCompasso) {
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
