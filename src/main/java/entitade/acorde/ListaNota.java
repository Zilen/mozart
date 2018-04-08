package entitade.acorde;

import java.util.ArrayList;

import entitade.nota.Nota;

public class ListaNota extends ArrayList<Nota> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 512099291227029631L;
	private int posicaoEscala;
	private Acorde acorde;
	private TipoAcorde tipoAcorde;
	
	public ListaNota(int i, int posicaoEscala, TipoAcorde tipoAcorde) {
		super(i);
		this.posicaoEscala = posicaoEscala;
		this.tipoAcorde =  tipoAcorde;
	}
	public ListaNota(int posicaoEscala) {
		super();
		this.posicaoEscala = posicaoEscala;
	}

	public String getNome() {
		StringBuilder sb = new StringBuilder(this.get(0).getCifra());
		
		this.forEach(n -> {
			diferenca(n, sb);
		});
		return sb.toString();
	}
	
	public void diferenca(Nota nota, StringBuilder sb) {
		switch (this.get(0).getDiferenca(nota)) {
		case 2:
			sb.append("9");
			break;
		case 3:
			sb.append("m");
			break;
		case 5:
			sb.append("sus");
			break;
		case 6:
			sb.append("(b5)");
			break;
		case 8:
			sb.append("(6b)");
			break;
		case 9:
			sb.append("6");
			break;
		case 10:
			sb.append("7");
			break;
		case 11:
			sb.append("7M");
			break;
		}
	}
	public int getPosicaoEscala() {
		return posicaoEscala;
	}
	public void setPosicaoEscala(int posicaoEscala) {
		this.posicaoEscala = posicaoEscala;
	}
	protected ListaNota acorde(Acorde acorde) {
		this.acorde = acorde;
		return this;
	}
	public Acorde getAcorde() {
		return acorde;
	}
	public TipoAcorde getTipoAcorde() {
		return tipoAcorde;
	}

}
