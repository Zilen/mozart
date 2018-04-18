package entitade.nota;

import entitade.Duracao;
import entitade.Intensidade;

public class NotaTocada {
	private Som nota;
	private Intensidade intensidade;
	private Duracao duracao;
	
	public NotaTocada(Som nota, Intensidade intensidade, Duracao duracao) {
		this.nota = nota;
		this.intensidade = intensidade;
		this.duracao = duracao;
	}
	
	public NotaTocada(Som som) {
		this.nota = som;
		this.intensidade = Intensidade.FF;
		this.duracao = Duracao.SEMINIMA;
	}

	public Som getNota() {
		return nota;
	}
	public void setNota(Som nota) {
		this.nota = nota;
	}
	public Intensidade getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(Intensidade intensidade) {
		this.intensidade = intensidade;
	}
	public Duracao getDuracao() {
		return duracao;
	}
	public void setDuracao(Duracao duracao) {
		this.duracao = duracao;
	}
}
