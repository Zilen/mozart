package entitade;

import java.util.ArrayList;

public class ListaNota extends ArrayList<Nota> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 512099291227029631L;
	
	
	public ListaNota(int i) {
		super(i);
	}
	public ListaNota() {
		super();
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

}
