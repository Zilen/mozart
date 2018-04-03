package entitade;

import java.util.List;

public class Acorde {
	
	public Acorde(Escala escala, Nota tonica, List<Nota> triade, List<Nota> setimo, List<Nota> nono, List<Nota> decimaTerceira, List<Nota> sus, List<Nota> sus7) {
		this.escala = escala;
		this.tonica = tonica;
		this.triade = triade;
		this.setimo = setimo;
		this.nono = nono;
		this.decimaTerceira = decimaTerceira;
		this.sus = sus;
		this.sus7 = sus7;
	}
	private Nota tonica;
	private Escala escala;
	private List<Nota> triade;
	private List<Nota> setimo;
	private List<Nota> nono;
	private List<Nota> decimaTerceira;
	private List<Nota> sus;
	private List<Nota> sus7;
	
	public Nota getTonica() {
		return tonica;
	}
	public Escala getEscala() {
		return escala;
	}
	public List<Nota> getTriade() {
		return triade;
	}
	public List<Nota> getSetimo() {
		return setimo;
	}
	public List<Nota> getNono() {
		return nono;
	}
	public List<Nota> getDecimaTerceira() {
		return decimaTerceira;
	}
	public List<Nota> getSus() {
		return sus;
	}
	public List<Nota> getSus7() {
		return sus7;
	}
	
}
