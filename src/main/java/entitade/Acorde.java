package entitade;

import java.util.List;

import entitade.acorde.TipoAcorde;

public class Acorde {
	
	public Acorde(Escala escala, Nota tonica, ListaNota triade, ListaNota setimo, ListaNota sexta, ListaNota nono, ListaNota decimaTerceira, ListaNota sus, ListaNota sus7, TipoAcorde tipoAcorde) {
		this.escala = escala;
		this.tonica = tonica;
		this.triade = triade;
		this.setimo = setimo;
		this.nono = nono;
		this.decimaTerceira = decimaTerceira;
		this.sus = sus;
		this.sus7 = sus7;
		this.sexta = sexta;
		this.tipoAcorde = tipoAcorde;
	}
	private Nota tonica;
	private Escala escala;
	private TipoAcorde tipoAcorde;
	private ListaNota triade;
	private ListaNota setimo;
	private ListaNota sexta;
	private ListaNota nono;
	private ListaNota decimaTerceira;
	private ListaNota sus;
	private ListaNota sus7;
	
	public Nota getTonica() {
		return tonica;
	}
	public Escala getEscala() {
		return escala;
	}
	public ListaNota getTriade() {
		return triade;
	}
	public ListaNota getSetima() {
		return setimo;
	}
	public ListaNota getNona() {
		return nono;
	}
	public ListaNota getDecimaTerceira() {
		return decimaTerceira;
	}
	public ListaNota getSus() {
		return sus;
	}
	public ListaNota getSus7() {
		return sus7;
	}
	public ListaNota getSexta() {
		return sexta;
	}
	public TipoAcorde getTipoAcorde() {
		return tipoAcorde;
	}
	
	
}
