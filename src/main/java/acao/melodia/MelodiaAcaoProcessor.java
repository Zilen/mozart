package acao.melodia;

import java.util.ArrayList;
import java.util.List;

import regra.Regra;
import Utils.Rand;
import acao.AcaoProcessor;
import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class MelodiaAcaoProcessor extends AcaoProcessor<Probabilidade<NotaTocada>> {


	public List<Regra<Probabilidade<NotaTocada>>> regras;

	public MelodiaAcaoProcessor(List<Regra<Probabilidade<NotaTocada>>> regras) {
		this.regras = regras;
	}

	public void calcular(Musica musica) {
		List<NotaTocada> notas = new ArrayList<NotaTocada>();
		while (musica.getTempoCalculadoAtual() < musica.getTempoPorCompasso() * musica.getQtdCompassos()) {
			int i = 0;

			List<Probabilidade<NotaTocada>> probabilidades = gerarProbabilidadeDefault(musica, notas);

			if(regras != null) {
				for(Regra<Probabilidade<NotaTocada>>regra : this.regras) {
					regra.isValid(probabilidades, musica, i++);
				}
			}
			notas.add(escolherNota(probabilidades, notas, musica));
		}
		musica.addNotas(notas);
	}

	private NotaTocada escolherNota(
			List<Probabilidade<NotaTocada>> probabilidadeNotas, List<NotaTocada> notas, Musica musica) {
		ListaNota acordeCompasso = musica.getAcordeInTempo(musica.getTempoCalculadoAtual());
		NotaTocada ultimaNota = null;
		NotaTocada nota = null;
		double somatoria = 0.0;
		Double chance = Rand.get().nextDouble();
		if(notas.isEmpty()) {
			do {
				ultimaNota = new NotaTocada(musica.getIntervalo().get(Rand.nextInt(musica.getIntervalo().size())));
			} while (naoPertenceAoAcorde(acordeCompasso, ultimaNota.getNota()));
		} else {
			ultimaNota = notas.get(notas.size() -1);
		}
		for(Probabilidade<NotaTocada> p : probabilidadeNotas) {
			somatoria += p.getChance();
			if(chance <= somatoria) {
				nota = p.get();
				break;
			}
		}

		if(System.getProperty("showNota") != null) {
			System.out.println("Nota calculada: "+ nota.toString());
		}

		musica.updateTempoCalculadoAtual(nota.getDuracao().getDuracaoReal());
		return nota;
	}

	private List<Probabilidade<NotaTocada>> gerarProbabilidadeDefault(Musica musica, List<NotaTocada> notas) {
		ListaNota acordeCompasso = musica.getAcordeInTempo(musica.getTempoCalculadoAtual());
		List<Probabilidade<NotaTocada>> mapaDefault = new ArrayList<Probabilidade<NotaTocada>>();
		List<Probabilidade<Som>> notaTocada = getNotaProbabiliade(musica, notas, acordeCompasso);

		Double chanceTotal = 0.0;

		for(Probabilidade<Som> som : notaTocada) {
			for(Duracao d : Duracao.values()) {

				double chance = som.getChance();
				if(acordeCompasso.pertenceAoAcorde(som.get())) {
				} else {
					switch(d) {
					case BREVE:
					case SEMIBREVE_AUMENTADA:
					case SEMIBREVE:
					case MINIMA_AUMENTADA:
					case MINIMA:
					case SEMINIMA_AUMENTADA:
						chance = 0.0;
						break;
					case SEMINIMA:
					case COLCHEIA:
					case SEMICOLCHEIA:
					case FUSA:
					case SEMIFUSA:
						break;
					}
				}

				switch(d) {
				case BREVE:
				case SEMIBREVE_AUMENTADA:
				case FUSA:
				case SEMIFUSA:
					chance = 0;
				}

				chanceTotal += chance;
				mapaDefault.add(new Probabilidade<NotaTocada>(chance, new NotaTocada(som.get(), null, d)));
			}
		}
		for(Probabilidade<NotaTocada> p : mapaDefault) {
			p.atualizarChance(p.getChance() / chanceTotal);
		}
		return mapaDefault;
	}

private List<Probabilidade<Som>> getNotaProbabiliade(Musica musica, List<NotaTocada> notas, ListaNota acordeCompasso) {
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
	probabilidadeNotas = Som.gerarProbabilidades(musica,
			ultimaNota.getNota(),acordeCompasso);
	return probabilidadeNotas;
}
private boolean naoPertenceAoAcorde(ListaNota acordeCompasso, Som notaTocada) {
	return !acordeCompasso.stream().anyMatch(a -> a.equals(notaTocada.getNota()));
}


}
