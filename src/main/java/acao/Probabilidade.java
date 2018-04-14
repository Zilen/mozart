package acao;

import entitade.Musica;

public class Probabilidade<T> extends Acao {

	private T t;
	public Probabilidade(double chance, T t) {
		super(chance);
		this.t = t;
	}

	@Override
	public void executar(Musica musica) {
		throw new RuntimeException("Método não utilizado");
	}
	
	public T get() {
		return t;
	}

}
