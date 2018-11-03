package acao.melodia;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import Utils.Rand;
import acao.AcaoProcessor;
import acao.Probabilidade;
import entitade.Duracao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.nota.Melodia;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import regra.melodia.RegraMelodia;

public class MelodiaAcaoProcessor extends AcaoProcessor<Probabilidade<NotaTocada>> {


	public List<RegraMelodia> regras;

	public MelodiaAcaoProcessor(List<RegraMelodia> regras) {
		this.regras = regras;
	}

	public void calcular(Musica musica) {
		Melodia notas = new Melodia();
		while (musica.getTempoCalculadoAtual() < musica.getTempoPorCompasso() * musica.getQtdCompassos()) {
			int i = 0;

			List<Probabilidade<NotaTocada>> probabilidades = gerarProbabilidadeDefault(musica, notas);

			if(regras != null) {
				for(RegraMelodia regra : this.regras) {
					regra.validarExecutar(probabilidades, musica, i++, notas);
				}
			}
			notas.addNota(escolherNota(probabilidades, notas, musica), musica);
		}
		musica.addNotas(notas);
	}

	public static NotaTocada escolherNota(
			List<Probabilidade<NotaTocada>> probabilidadeNotas, List<NotaTocada> notas, Musica musica) {

		//TODO modificar Double para BigDecimal
		if(probabilidadeNotas.stream().mapToDouble(i -> i.getChance()).sum() > 1.00000000000001) {
			throw new InvalidParameterException("Somatoria de probabilidades ultrapassa 100,000000000001% - "+probabilidadeNotas.stream().mapToDouble(i -> i.getChance()).sum());
		}

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
private static boolean naoPertenceAoAcorde(ListaNota acordeCompasso, Som notaTocada) {
	return !acordeCompasso.stream().anyMatch(a -> a.equals(notaTocada.getNota()));
}


}
