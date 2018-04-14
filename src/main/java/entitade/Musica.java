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
	private Integer tempoPorCompasso;
	private Integer qtdCompassos;

	public Musica(Escala escala, Integer tempo, Integer tempoPorCompasso, Integer qtdCompassos) {
		this(escala, tempo, true, tempoPorCompasso, qtdCompassos);
	}
	
	
	public Musica(Escala escala, Integer tempo, boolean isArpegio, Som notaBase, Som notaMelodia,  Integer tempoPorCompasso, Integer qtdCompassos) {
		this.escala = escala;
		this.melodia = new ArrayList<NotaTocada>();
		this.acordes = new ArrayList<ListaNota>();
		this.notaBaseBaixo = notaBase;
		this.notaBaseMelodia = notaMelodia;
		this.intervalo = Som.intervalo(this.getEscala(), this.getNotaBaseMelodia());                                 
		this.intervaloBase = Som.intervalo(this.getEscala(), this.getNotaBaseBaixo(), this.getNotaBaseMelodia());
		this.arpegio = isArpegio;
		this.tempo= tempo;
		this.tempoPorCompasso = tempoPorCompasso;
		this.qtdCompassos = qtdCompassos;
	}
	public Musica(Escala escala, Integer tempo, boolean isArpegio,  Integer tempoPorCompasso, Integer qtdCompassos) {
		this(escala, tempo, isArpegio, 
				notaBase(escala, 3),
				notaBase(escala, 5),
				tempoPorCompasso, qtdCompassos);
	}
	private static Som notaBase(Escala escala, Integer local) {
		return (Som.getList().stream().filter(s -> { return s.name().equals(escala.getI().name().toUpperCase()+local.toString()); }).findFirst().get());
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
	
	public ListaNota getAcordeInTempo(Double tempo) {
		return this.acordes.get(this.getposicaoAcorde(tempo)-1);
	}
	public ListaNota getAcordeInTempo(Integer tempo) {
		return this.getAcordeInTempo(tempo.doubleValue());
	}
	private int getposicaoAcorde(double tempo) {
		if(tempo < this.getTempoPorCompasso().doubleValue()) {
			return 1;
		} else {
			return 1+getposicaoAcorde(tempo-this.getTempoPorCompasso());
		}
	}

	public Integer getTempoPorCompasso() {
		return tempoPorCompasso;
	}


	public Integer getQtdCompassos() {
		return qtdCompassos;
	}
}
