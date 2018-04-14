package acao.melodia;

import java.util.ArrayList;
import java.util.List;

import Utils.Rand;
import acao.AcaoProcessor;
import entitade.Duracao;
import entitade.Intensidade;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import regra.Regra;

public class MelodiaAcaoProcessor extends AcaoProcessor<FraseAcao> {
	
	
	public List<Regra> regras;
	
	public MelodiaAcaoProcessor(List<Regra> regras) {
		this.regras = regras;
	}
	
	public void calcular(Musica musica) {
		Duracao[] duracoes = Duracao.values();
		ArrayList<NotaTocada> notas = new ArrayList<NotaTocada>();
		double tempo = 0.0;
		while (tempo < musica.getTempoPorCompasso() * musica.getQtdCompassos()) {
			Duracao tempoCalculado = duracoes[Rand.between(0, duracoes.length -1)];
			tempo += tempoCalculado.getDuracao() *4.0;
			ListaNota acordeCompasso = musica.getAcordeInTempo(tempoCalculado.getDuracao());
			Som notaTocada = null;
			do {
				notaTocada = musica.getIntervalo().get(Rand.nextInt(musica.getIntervalo().size()));
			} while (naoPertenceAoAcorde(acordeCompasso, notaTocada));
			
			notas.add(new NotaTocada(notaTocada, Intensidade.FF, tempoCalculado));
		}
		musica.addNotas(notas);
	}

	private boolean naoPertenceAoAcorde(ListaNota acordeCompasso, Som notaTocada) {
		return !acordeCompasso.stream().anyMatch(a -> a.equals(notaTocada.getNota()));
	}


}
