package acao.melodia;

import java.util.ArrayList;
import java.util.List;

import Utils.Rand;
import acao.AcaoProcessor;
import acao.Probabilidade;
import entitade.Duracao;
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
		List<NotaTocada> notas = new ArrayList<NotaTocada>();
		double tempo = 0.0;
		while (tempo < musica.getTempoPorCompasso() * musica.getQtdCompassos()) {
			ListaNota acordeCompasso = musica.getAcordeInTempo(tempo);
			Som notaTocada = getNota(musica, notas, acordeCompasso);
			Duracao tempoCalculado = getTempo(musica, notas, tempo, notaTocada, acordeCompasso);
			tempo += tempoCalculado.getDuracao() *4.0;
			notas.add(new NotaTocada(notaTocada, null, tempoCalculado));
		}
		musica.addNotas(notas);
	}

	private Duracao getTempo(Musica musica, List<NotaTocada> notas, double tempo, Som notaTocada, ListaNota acordeCompasso) {
		NotaTocada ultimaNota = null;
		Duracao duracao = null;
		List<Probabilidade<Duracao>> probabilidadeNotas = null;
		double somatoria = 0.0;
		Double chance = Rand.get().nextDouble();
		if(notas.isEmpty()) {
			ultimaNota = new NotaTocada(musica.getIntervalo().get(Rand.nextInt(musica.getIntervalo().size())));
		} else {
			ultimaNota = notas.get(notas.size() -1);
		}
		probabilidadeNotas = Duracao.gerarProbabilidades(ultimaNota, musica, tempo, notaTocada, acordeCompasso);
		for(Probabilidade<Duracao> p : probabilidadeNotas) {
			somatoria += p.getChance();
			if(chance <= somatoria) {
				duracao = p.get();
				break;
			}
		}
		return duracao;
	}

private Som getNota(Musica musica, List<NotaTocada> notas, ListaNota acordeCompasso) {
	NotaTocada ultimaNota = null;
	Som nota = null;
	List<Probabilidade<Som>> probabilidadeNotas = null;
	double somatoria = 0.0;
	Double chance = Rand.get().nextDouble();
	if(notas.isEmpty()) {
		do {
			ultimaNota = new NotaTocada(musica.getIntervalo().get(Rand.nextInt(musica.getIntervalo().size())));
		} while (naoPertenceAoAcorde(acordeCompasso, ultimaNota.getNota()));
	} else {
		ultimaNota = notas.get(notas.size() -1);
	}
	probabilidadeNotas = Som.gerarProbabilidades(musica.getIntervalo(), musica.getIntervaloCromaticoMelodia(),
			ultimaNota.getNota(), musica.getEscala(),acordeCompasso);
	for(Probabilidade<Som> p : probabilidadeNotas) {
		somatoria += p.getChance();
		if(chance <= somatoria) {
			nota = p.get();
			break;
		}
	}
	return nota;
}
private boolean naoPertenceAoAcorde(ListaNota acordeCompasso, Som notaTocada) {
	return !acordeCompasso.stream().anyMatch(a -> a.equals(notaTocada.getNota()));
}


}
