package acao;
import entitade.Musica;

public abstract class Acao {
	
	protected Double chance;

	public Acao(double chance) {
		this.chance = chance;
	}
	public Double getChance() {
		return chance;
	};

	public Double getChanceInversa() {
		return 1.0 - chance;
	};
	
	abstract public void executar(Musica musica);
	
	public void atualizarChance(Double novaChance) {
		this.chance = novaChance;
		this.checkChance();
	}
	
	public void somarChance(Double novaChance) {
		this.chance += novaChance;
		this.checkChance();
	}
	
	public void subtrairChance(Double novaChance) {
		this.chance -= novaChance;
		this.checkChance();
	}
	
	private void checkChance() {
		if(chance > 1.0) {
			throw new RuntimeException("probabilidade maior que 1");
		}
	}
}
