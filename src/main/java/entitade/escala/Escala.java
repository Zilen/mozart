package entitade.escala;

import java.util.ArrayList;
import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.acorde.Acorde;
import entitade.acorde.AcordeBuilder;
import entitade.nota.Nota;
import entitade.nota.Som;

public abstract class Escala {

	private List<Nota> notas;
	private List<Acorde> acordes;
	private List<AcordesAcao> acordesAcaoList;
	private List<NotaAcorde> notaAcordeList;

	Escala(Nota tonica) {
		if(tonica == null) {
			tonica = Nota.C;
		}
		notas = new ArrayList<Nota>(this.getNumeroDeNotas());
		this.notaAcordeList = new ArrayList<NotaAcorde>(7);
		this.acordesAcaoList = new ArrayList<AcordesAcao>(7);
		this.setNota(tonica.setPosicaoNaEscala(1));
		this.setNota(this.getToII().setPosicaoNaEscala(2));
		this.setNota(this.getToIII().setPosicaoNaEscala(3));
		this.setNota(this.getToIV().setPosicaoNaEscala(4));
		this.setNota(this.getToV().setPosicaoNaEscala(5));
		if (this.getNumeroDeNotas() > 5)
		this.setNota(this.getToVI().setPosicaoNaEscala(6));
		if (this.getNumeroDeNotas() > 6)
		this.setNota(this.getToVII().setPosicaoNaEscala(7));
		if (this.getNumeroDeNotas() >= 7) {
			this.popularAcordes();
			this.notaAcordeList.forEach(n -> {
				if (n.acorde().getPosicaoEscala() == 1) {
					this.acordesAcaoList.add(new AcordesAcao(1.0, n.acorde()
							.getTriade()));
				} else {
					this.acordesAcaoList.add(new AcordesAcao(0.0, n.acorde()
							.getTriade()));
				}
			});
		}
	}

	private void setNota(Nota nota) {
		notas.add(nota);
		notaAcordeList.add(new NotaAcorde(nota));
	}

	public NotaAcorde getI() {
		return this.notaAcordeList.get(0);
	}

	public NotaAcorde getII() {
		return this.notaAcordeList.get(1);
	}

	public NotaAcorde getIII() {
		return this.notaAcordeList.get(2);
	}

	public NotaAcorde getIV() {
		return this.notaAcordeList.get(3);
	}

	public NotaAcorde getV() {
		return this.notaAcordeList.get(4);
	}

	public NotaAcorde getVI() {
		return this.notaAcordeList.get(5);
	}

	public NotaAcorde getVII() {
		return this.notaAcordeList.get(6);
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
			this.notas.forEach(n -> {
				Acorde a = AcordeBuilder.build(this, n);
				this.acordes.add(a);
				this.putOnNotaAcordeList(n, a);
			});
		}
		return this.acordes;
	}

	private void putOnNotaAcordeList(Nota n, Acorde a) {
		for(NotaAcorde notaAcorde : notaAcordeList) {
			if(notaAcorde.nota().equals(n)) {
				notaAcorde.setAcorde(a);
				break;
			}
		}
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

	private Escala popularAcordes() {
		this.getNotas().forEach(n -> this.putOnNotaAcordeList(n, AcordeBuilder.build(this, n)));
		return this;
	}

	public boolean pertence(Som s) {
		return this.getNotas().stream().anyMatch(n -> n.equals(s.getNota()));
	}

	public List<AcordesAcao> getAcordesAcaoList() {
		return acordesAcaoList;
	}

	public abstract String getNome();

	public class NotaAcorde {
		private Nota nota;
		private Acorde acorde;
		public Nota nota() {
			return nota;
		}
		public Acorde acorde() {
			return acorde;
		}
		public NotaAcorde(Nota nota) {
			super();
			this.nota = nota;
		}
		public void setAcorde(Acorde acorde) {
			this.acorde = acorde;
		}
	}

	public Integer getNumeroDeNotas(){
		return 7;
	}

	public Nota getTonica() {
		return this.getI().nota;
	}
}
