package regra.melodia;

import java.util.ArrayList;
import java.util.List;

import acao.AcaoProcessor;
import acao.Probabilidade;
import entitade.Musica;
import entitade.nota.Melodia;
import entitade.nota.NotaTocada;
import regra.Regra;

public abstract class RegraMelodia implements Regra<Probabilidade<NotaTocada>> {

	@Override
	public Integer getPosicaoPrimeiro() {
		return null;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return null;
	}

	protected AcaoProcessor<Probabilidade<NotaTocada>> processor;
	private Melodia notas;
	private Musica musica;

	public AcaoProcessor<Probabilidade<NotaTocada>> getProcessor() {
		return processor;
	}

	public void setProcessor(AcaoProcessor<Probabilidade<NotaTocada>> processor) {
		this.processor = processor;
	}

	public void validarExecutar(List<Probabilidade<NotaTocada>> acao, Musica musica,
			Integer iteration, Melodia notas) {
		this.notas = notas;
		if(this.isValid(acao, musica, iteration)) {
			this.executar(acao, musica, iteration);
		}
		this.recalcular(acao);
		this.notas = null;
		this.musica = musica;
	}

	private void recalcular(List<Probabilidade<NotaTocada>> acao) {
		double somatoria = acao.stream().mapToDouble(a -> a.getChance()).sum();
		acao.forEach(a -> a.atualizarChance(a.getChance() / somatoria));
	}

	protected List<NotaTocada> getNotas() {
		return notas;
	}

	public List<NotaTocada> getNotasInCompasso() {
		List<NotaTocada> notasNoAcorde = new ArrayList<NotaTocada>();
		Double tempoInicialCompasso = musica.getTempoInicioCompassoAtual();

		double tempo = 0;
		for(NotaTocada nota : this.getNotas()) {
			tempo += nota.getDuracao().getDuracaoReal();
			if(tempo > tempoInicialCompasso) {
				notasNoAcorde.add(nota);
			}
		}
		return notasNoAcorde;
	}

	public Double getTempoRestanteAcorde() {
		Double tempoInicialCompasso = musica.getTempoInicioCompassoAtual();
		double tempo = 0;
		for(NotaTocada nota : this.getNotas()) {
			tempo += nota.getDuracao().getDuracaoReal();
		}
		return tempo - tempoInicialCompasso;
	}

}
