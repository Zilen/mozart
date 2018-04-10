package entitade;

public enum Duracao {
	SEMIBREVE(1.0),
	MINIMA(0.5),
	SEMINIMA(0.25),
	COLCHEIA(0.125),
	SEMICOLCHEIA(0.0625),
	FUSA(0.0313),
	SEMIFUSA(0.015625),
	SEMINIMA_AUMENTADA(COLCHEIA.getDuracao() + MINIMA.getDuracao()),
	MINIMA_AUMENTADA(MINIMA.getDuracao() + SEMINIMA.getDuracao());
	
	
	private Double duracao;
	private Duracao(Double duracao) {
		this.duracao = duracao;
	}
	public Double getDuracao() {
		return duracao;
	}
}
