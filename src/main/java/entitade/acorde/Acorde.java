package entitade.acorde;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entitade.escala.Escala;
import entitade.nota.Nota;

public class Acorde {
	

	public Acorde(Escala escala, Nota tonica, ListaNota triade, ListaNota setimo, ListaNota sexta, ListaNota nono, ListaNota decimaTerceira, ListaNota sus, ListaNota sus7, TipoAcorde tipoAcorde, int posicao) {
		this.escala = escala;
		this.tonica = tonica;
		this.triade = triade.acorde(this);
		this.setimo = setimo.acorde(this);
		this.nono = nono.acorde(this);
		this.decimaTerceira = decimaTerceira.acorde(this);
		this.sus = sus.acorde(this);
		this.sus7 = sus7.acorde(this);
		this.sexta = sexta.acorde(this);
		this.tipoAcorde = tipoAcorde;
		this.posicaoEscala = posicao;
	}
	private int posicaoEscala;
	private Nota tonica;
	@JsonIgnore
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
	@JsonIgnore
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
	public int getPosicaoEscala() {
		return posicaoEscala;
	}
	
	
}
