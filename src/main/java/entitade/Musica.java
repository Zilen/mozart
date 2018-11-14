package entitade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.nota.Melodia;
import entitade.nota.NotaTocada;
import entitade.nota.Som;

public class Musica {
	private List<ListaNota> acordes;
	private Melodia melodia;
	private Escala escala;
	private Integer tempo;
	private Boolean arpegio;
	private Som notaBaseMelodia;
	private Som notaBaseBaixo;
	private List<Som> intervalo;
	private List<Som> intervaloBase;
	private List<Som> intervaloCromaticoMelodia;
	private Integer tempoPorCompasso;
	private Integer qtdCompassos;
	private boolean notasForaDaEscala;
	private double tempoCalculadoAtual = 0;

	public Musica(Escala escala, Integer tempo, boolean isArpegio, Som notaBase, Som notaMelodia,  Integer tempoPorCompasso, Integer qtdCompassos, boolean notasForaDaEscala) {
		this.escala = escala;
		this.melodia = new Melodia();
		this.acordes = new ArrayList<ListaNota>();
		this.notaBaseBaixo = notaBase;
		this.notaBaseMelodia = notaMelodia;
		this.intervalo = Som.intervalo(this.getEscala(), this.getNotaBaseMelodia());
		this.intervaloCromaticoMelodia = Som.intervalo(this.intervalo.get(0), this.intervalo.get(this.intervalo.size() - 1));
		this.intervaloBase = Som.intervalo(this.getEscala(), this.getNotaBaseBaixo(), this.getNotaBaseMelodia());
		this.arpegio = isArpegio;
		this.tempo= tempo;
		this.tempoPorCompasso = tempoPorCompasso;
		this.qtdCompassos = qtdCompassos;
		this.notasForaDaEscala = notasForaDaEscala;
	}


	public Musica(Escala escala, Integer tempo, boolean isArpegio,  Integer tempoPorCompasso, Integer qtdCompassos, boolean notasForaDaEscala) {
		this(escala, tempo, isArpegio,
				notaBase(escala, 3),
				notaBase(escala, 5),
				tempoPorCompasso, qtdCompassos,
				notasForaDaEscala);
	}
	private static Som notaBase(Escala escala, Integer local) {
		return (Som.getList().stream().filter(s -> { return s.name().equals(escala.getI().nota().name().toUpperCase()+local.toString()); }).findFirst().get());
	}

	//para o regraBuilder
	public Musica(){
		this.acordes = new ArrayList<ListaNota>();
	};

	public void addNota(NotaTocada nota) {
		this.melodia.add(nota);
	}
	public void addNota(NotaTocada... notas) {
		this.melodia.addAll(Arrays.asList(notas));
	}
	public void addNotas(List<NotaTocada> notas) {
		for (NotaTocada nota : notas) {
			this.melodia.addNota(nota, this);
		}
	}
	public void addAcode(ListaNota acorde) {
		this.acordes.add(acorde);
	}
	public List<ListaNota> getAcordes() {
		return acordes;
	}
	public Melodia getMelodia() {
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
	public int getposicaoAcorde(double tempo) {
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


	public List<Som> getIntervaloCromaticoMelodia() {
		return intervaloCromaticoMelodia;
	}


	public void setIntervaloCromaticoMelodia(List<Som> intervaloCromaticoMelodia) {
		this.intervaloCromaticoMelodia = intervaloCromaticoMelodia;
	}


	public boolean isNotasForaDaEscala() {
		return notasForaDaEscala;
	}


	public void setNotasForaDaEscala(boolean notasForaDaEscala) {
		this.notasForaDaEscala = notasForaDaEscala;
	}

	public Integer getTempoMusica() {
		return this.getQtdCompassos() * this.getTempoPorCompasso();
	}

	public void addParte(Musica parte) {
		parte.getAcordes().forEach(a-> this.addAcode(a));
		this.addNota(parte.getMelodia().toArray(new NotaTocada[parte.getMelodia().size()]));
	}

	public Musica copyProperties(Musica musica) {
		this.arpegio = musica.isArpegio();
		this.escala = musica.getEscala();
		this.intervalo = musica.getIntervalo();
		this.intervaloBase = musica.getIntervaloBase();
		this.intervaloCromaticoMelodia = musica.getIntervaloCromaticoMelodia();
		this.notaBaseBaixo = musica.getNotaBaseBaixo();
		this.notaBaseMelodia = musica.getNotaBaseMelodia();
		this.notasForaDaEscala = musica.isNotasForaDaEscala();
		this.qtdCompassos = musica.getQtdCompassos();
		this.tempo = musica.getTempo();
		this.tempoPorCompasso = musica.getTempoPorCompasso();

		return this;
	}

	public void setAcordes(List<ListaNota> acordes) {
		this.acordes = acordes;
	}

	public double getTempoCalculadoAtual() {
		return tempoCalculadoAtual;
	}

	public void updateTempoCalculadoAtual(double tempoAAdicionar) {
		this.tempoCalculadoAtual += tempoAAdicionar;
	}

	public List<NotaTocada> getNotasInCompasso() {
		List<NotaTocada> notasNoAcorde = new ArrayList<NotaTocada>();
		Double tempoInicialCompasso = this.getTempoInicioCompassoAtual();

		double tempo = 0;
		for(NotaTocada nota : this.getMelodia()) {
			tempo += nota.getDuracao().getDuracaoReal();
			if(tempo > tempoInicialCompasso) {
				notasNoAcorde.add(nota);
			}
		}
		return notasNoAcorde;
	}

	public NotaTocada getUltimaNota() {
		return this.getMelodia().get(this.getMelodia().size() -1);
	}

	public double getTempoInicioCompassoAtual() {
		return ((Integer)(this.getposicaoAcorde(this.getTempoCalculadoAtual()) * this.getTempoPorCompasso())).doubleValue();
	}
}
