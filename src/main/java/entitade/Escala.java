package entitade;

import java.util.ArrayList;
import java.util.List;

public abstract class Escala {

	private Nota I;
	private List<Nota> notas;
	private List<Acorde> acordes;

	Escala(Nota tonica) {
		notas = new ArrayList<Nota>(7);
		notas.add(tonica.setPosicaoNaEscala(1));
		notas.add(this.getToII().setPosicaoNaEscala(2));
		notas.add(this.getToIII().setPosicaoNaEscala(3));
		notas.add(this.getToIV().setPosicaoNaEscala(4));
		notas.add(this.getToV().setPosicaoNaEscala(5));
		notas.add(this.getToVI().setPosicaoNaEscala(6));
		notas.add(this.getToVII().setPosicaoNaEscala(7));
	}

	public Nota getI() {
		return this.notas.get(0);
	}

	public Nota getII() {
		return this.notas.get(1);
	}

	public Nota getIII() {
		return this.notas.get(2);
	}

	public Nota getIV() {
		return this.notas.get(3);
	}

	public Nota getV() {
		return this.notas.get(4);
	}

	public Nota getVI() {
		return this.notas.get(5);
	}

	public Nota getVII() {
		return this.notas.get(6);
	}

	protected abstract Nota getToII();

	protected abstract Nota getToIII();

	protected abstract Nota getToIV();

	protected abstract Nota getToV();

	protected abstract Nota getToVI();

	protected abstract Nota getToVII();

	public List<Nota> getNotas() {
		return this.notas;
	}
	
	public List<Acorde> getAcordes() {
		if(this.acordes == null) {
			this.acordes = new ArrayList<Acorde>(7);
			this.notas.forEach(n -> { this.acordes.add(n.acorde(this)); });
		}
		return this.acordes;
	}
	
	public void printNotas() {
		System.out.println("\n");
		this.notas.forEach(n -> {
			System.out.print(n.getNome()+" ");
			});
		System.out.println("\n");
	}

	public Nota getNotaNaPosicao(Integer posicao) {
		return notas.get(posicao-1);
	}

	public Nota relativa(Nota nota, int posicaoRelativa) {
		Integer posicao = (nota.getPosicaoNaEscala() + posicaoRelativa -2); 
		if (posicao >= 7) {
			posicao %= 7;
		}
		return notas.get(posicao);
	};

}
