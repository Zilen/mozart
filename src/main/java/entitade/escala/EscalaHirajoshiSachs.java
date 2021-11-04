package entitade.escala;

import entitade.nota.Nota;

public class EscalaHirajoshiSachs extends Escala {

	public EscalaHirajoshiSachs(Nota tonica) {
		super(tonica);
	}

	@Override
	protected  Nota getToII() {
		return Nota.semitom(getI().getNota());
	}

	@Override
	protected  Nota getToIII() {
		//não tem terceiro
		return getToII();
	}

	@Override
	protected Nota getToIV() {
		return Nota.tomtom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.tomtom(getToIV());
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
		return "Escala Hirajoshi segundo Sachs";
	}
	
}
