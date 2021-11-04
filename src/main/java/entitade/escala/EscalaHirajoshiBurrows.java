package entitade.escala;

import entitade.nota.Nota;

public class EscalaHirajoshiBurrows extends Escala {

	public EscalaHirajoshiBurrows(Nota tonica) {
		super(tonica);
	}

	@Override
	protected  Nota getToII() {
		//não tem segundo grau
		return getI().getNota();
	}

	@Override
	protected  Nota getToIII() {
		return Nota.tomtom(getToII());
	}

	@Override
	protected Nota getToIV() {
		return Nota.tom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.semitom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		//não tem sexto
		return getToV();
	}

	@Override
	protected Nota getToVII() {
		return Nota.tomtom(getToVI());
	}

	@Override
	public String getNome() {
		return "Escala Hirajoshi segundo Burrows";
	}
	
}
