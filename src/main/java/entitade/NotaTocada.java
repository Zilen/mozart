package entitade;

public class NotaTocada {
	private Nota nota;
	private Intensidade intensidade;
	private Duracao duracao;
	
	public NotaTocada(Nota nota, Intensidade intensidade, Duracao duracao) {
		this.nota = nota;
		this.intensidade = intensidade;
		this.duracao = duracao;
	}
	
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
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
