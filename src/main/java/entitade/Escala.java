package entitade;

public abstract class Escala {
	
	private Nota tônica;
	
	Escala(Nota tônica) {
		this.tônica = tônica;
	}

	public Nota getTônica() {
		return tônica;
	}
	
	public Nota getI() {
		return tônica;
	}
	abstract Nota getII();
	abstract Nota getIII();
	abstract Nota getIV();
	abstract Nota getV();
	abstract Nota getVI();
	abstract Nota getVII();
	
	public void print() {
		System.out.println(getI().getNome()+" "+getII().getNome()+" "+getIII().getNome()+" "+getIV().getNome()+" "+getV().getNome()+" "+getVI().getNome()+" "+getVII().getNome());
	}
}
