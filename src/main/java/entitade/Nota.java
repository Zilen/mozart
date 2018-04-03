package entitade;

import entitade.acorde.AcordeBuilder;

public enum Nota {
	A(1, "Lá"),
	As(2, "Lá#"),
	B(3, "Si"),
	C(4, "Dó"),
	Cs(5, "Dó#"),
	D(6, "Ré"),
	Ds(7, "Ré#"),
	E(8, "Mi"),
	F(9, "Fá"),
	Fs(10, "Fá#"),
	G(11, "Sol"),
	Gs(12, "Sol#");

	private Integer posicao;
	private String nome;
	private Integer posicaoNaEscala;
	private Acorde acorde;
	
	private Nota(Integer posicao, String nome) {
		this.posicao = posicao;
		this.nome = nome;
		this.posicaoNaEscala = null;
		this.acorde = null;
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
}
