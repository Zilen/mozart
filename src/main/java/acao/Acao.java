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
	
	abstract public void executar(Musica musica);
	
	public void atualizarChance(Double novaChance) {
		this.chance = novaChance;
	}
	
	public void somarChance(Double novaChance) {
		this.chance += novaChance;
	}
	
	public void subtrairChance(Double novaChance) {
		this.chance -= novaChance;
	}
}
