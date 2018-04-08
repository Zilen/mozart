package entitade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class Musica {
	private List<ListaNota> acordes;
	private List<NotaTocada> melodia;
	private Escala escala;
	private Integer tempo;
	private Boolean arpegio;
	private Som notaBaseMelodia;
	private Som notaBaseBaixo;
	private List<Som> intervalo;
	private List<Som> intervaloBase;

	public Musica(Escala escala, Integer tempo) {
		this(escala, tempo, true);
	}
	
	public Musica(Escala escala, Integer tempo, boolean isArpegio) {
		this.escala = escala;
		this.melodia = new ArrayList<NotaTocada>();
		this.acordes = new ArrayList<ListaNota>();
		this.setNotaBaseMelodia(Som.getList().stream().filter(s -> { return s.name().equals(escala.getI().name().toUpperCase()+"5"); }).findFirst().get());
		this.setNotaBaseBaixo(Som.getList().stream().filter(s -> { return s.name().equals(escala.getI().name().toUpperCase()+"3"); }).findFirst().get());
		this.intervalo = Som.intervalo(this.getEscala(), this.getNotaBaseMelodia());                                 
		this.intervaloBase = Som.intervalo(this.getEscala(), this.getNotaBaseBaixo(), this.getNotaBaseMelodia());
		this.arpegio = isArpegio;
		this.tempo= tempo;
	}
	public void addNota(NotaTocada nota) {
		this.melodia.add(nota);
	}
	public void addNota(NotaTocada... notas) {
		this.melodia.addAll(Arrays.asList(notas));
	}
	public void addNotas(List<NotaTocada> notas) {
		this.melodia.addAll(notas);
	}
	public void addAcode(ListaNota acorde) {
		this.acordes.add(acorde);
	}
	public List<ListaNota> getAcordes() {
		return acordes;
	}
	public List<NotaTocada> getMelodia() {
		return melodia;
	}
	public Escala getEscala() {
		return escala;
	}
	public void setEscala(Escala escala) {
		this.escala = escala;
	}
	public Integer getTempo() {
		return tempo;
	}
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	public Boolean isArpegio() {
		return arpegio;
	}
	public void setArpegio(Boolean arpegio) {
		this.arpegio = arpegio;
	}
	public Som getNotaBaseMelodia() {
		return notaBaseMelodia;
	}
	public void setNotaBaseMelodia(Som notaBaseMelodia) {
		this.notaBaseMelodia = notaBaseMelodia;
	}
	public Som getNotaBaseBaixo() {
		return notaBaseBaixo;
	}
	public void setNotaBaseBaixo(Som notaBaseBaixo) {
		this.notaBaseBaixo = notaBaseBaixo;
	}

	public List<Som> getIntervalo() {
		return intervalo;
	}

	public List<Som> getIntervaloBase() {
		return intervaloBase;
	}
}
