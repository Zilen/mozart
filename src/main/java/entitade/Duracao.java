package entitade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import acao.Probabilidade;
import entitade.acorde.ListaNota;
import entitade.nota.NotaTocada;
import entitade.nota.Som;
import math.DistribuicaoNormal;

public enum Duracao {
	SEMIBREVE(1.0),
	MINIMA_AUMENTADA(0.5 + 0.25),
	MINIMA(0.5),
	SEMINIMA_AUMENTADA(0.125 + 0.25),
	SEMINIMA(0.25),
//	COLCHEIA_AUMENTADA(0.125 + 0.0625),
	COLCHEIA(0.125),
	SEMICOLCHEIA(0.0625),
	FUSA(0.0313),
	SEMIFUSA(0.015625);


	private Double duracao;
	private Duracao(Double duracao) {
		this.duracao = duracao;
	}
	public Double getDuracao() {
		return duracao;
	}

	public static List<Probabilidade<Duracao>> gerarProbabilidades(NotaTocada ultimaNota, Musica musica, double tempo, Som notaTocada, ListaNota acordeCompasso) {
		List<Duracao> duracoes = Arrays.asList(values());
		List<Probabilidade<Duracao>> duracaoProbabilidade = new ArrayList<Probabilidade<Duracao>>(5);
		Integer posicaoUltimaDuracao = 0;
		Integer iterator = 0;
		boolean pertenceAoAcorde = acordeCompasso.pertenceAoAcorde(notaTocada);
		Double somatoria = 0.0;
		Double s = 0.9;
		for(Duracao d : duracoes) {
			if(d.equals(ultimaNota.getDuracao())) {
				break;
			}
			posicaoUltimaDuracao++;
		}
		for(Duracao d : duracoes) {
			Double valor = DistribuicaoNormal.getY(iterator.doubleValue(), posicaoUltimaDuracao > 5.0 ? 5.0 : posicaoUltimaDuracao.doubleValue(), s);
			switch (d) {
			case SEMIFUSA:
			case FUSA:
				valor = 0.0;
				break;
			case SEMICOLCHEIA:
				valor /=3;
				break;
			case SEMIBREVE:
				valor /=1.6;
			default:
				break;
			}
			duracaoProbabilidade.add(new Probabilidade<Duracao> (valor, d));
			somatoria += valor;
			iterator++;
		}
		
		//caso nota nao pertença ao acorde, não segurar
		if(!pertenceAoAcorde) {
			somatoria = 0.0;
			for(Probabilidade<Duracao> d : duracaoProbabilidade) {
				switch(d.get()) {
				case SEMIBREVE:
				case MINIMA:
				case SEMINIMA_AUMENTADA:
				case MINIMA_AUMENTADA:
					d.atualizarChance(0.0);
					somatoria+= d.getChance();
					break;
				default:
					somatoria+= d.getChance();
					break;
				}
			}
		}
		for(Probabilidade<Duracao> d : duracaoProbabilidade) {
			d.atualizarChance(d.getChance() / somatoria);
		}
		return duracaoProbabilidade;
	}
	public static Duracao byDuracao(double tempo) {
		Duracao duracao = null;
		for(Duracao d : values()) {
			if(d.getDuracao().equals(tempo)) {
				duracao = d;
				break;
			}
		}
		return duracao;
	}
}
