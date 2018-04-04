package entitade;

import entitade.acorde.AcordeBuilder;

public enum Nota {
	A(1, "L�", "A"),
	As(2, "L�#", "A#"),
	B(3, "Si", "B"),
	C(4, "D�", "C"),
	Cs(5, "D�#", "C#"),
	D(6, "R�", "D"),
	Ds(7, "R�#", "D#"),
	E(8, "Mi", "E"),
	F(9, "F�", "F"),
	Fs(10, "F�#", "F#"),
	G(11, "Sol", "G"),
	Gs(12, "Sol#", "G#");

	private Integer posicao;
	private String nome;
	private Integer posicaoNaEscala;
	private Acorde acorde;
	private String cifra;
	
	private Nota(Integer posicao, String nome, String cifra) {
		this.posicao = posicao;
		this.nome = nome;
		this.posicaoNaEscala = null;
		this.acorde = null;
		this.cifra = cifra;
	}
	
	
	public String getNome() {
		return nome;
	}


	public static Nota semitom(Nota nota) {
		return getByPosicao(nota.posicao+1);
	}
	
	public static Nota tom(Nota nota) {
		return getByPosicao(nota.posicao+2);
	}
	
	public static Nota tomSemitom(Nota nota) {
		return getByPosicao(nota.posicao+3);
	}
	
	private static Nota getByPosicao(Integer posicao) {
		Integer pos = posicao > 12 ? posicao % 12 : posicao;
		for(Nota n : values()) {
			if(n.posicao.equals(pos)) {
				return n;
			}
		}
		return null;
	}


	public Integer getPosicaoNaEscala() {
		return posicaoNaEscala;
	}


	public Nota setPosicaoNaEscala(Integer posicaoNaEscala) {
		this.posicaoNaEscala = posicaoNaEscala;
		return this;
	}
	
	public Acorde acorde(Escala escala) {
		if(this.acorde == null) {
			this.acorde =  AcordeBuilder.build(escala, this);
		}
		return this.acorde;
	}
	
	public Acorde acorde() {
		return this.acorde;
	}


	public String getCifra() {
		return cifra;
	}
	
	public Integer getDiferenca(Nota nota) {
		Integer posicaoNota = nota.posicao < this.posicao ? nota.posicao + 12 : nota.posicao;
		return posicaoNota - this.posicao;
	}
}
