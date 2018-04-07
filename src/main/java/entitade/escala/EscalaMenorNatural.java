package entitade.escala;

import entitade.nota.Nota;

public class EscalaMenorNatural extends Escala {

	public EscalaMenorNatural(Nota tonica) {
		super(tonica);
	}

	@Override
	protected  Nota getToII() {
		return Nota.tom(getI());
	}

	@Override
	protected  Nota getToIII() {
		return Nota.semitom(getToII());
	}

	@Override
	protected Nota getToIV() {
		return Nota.tom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.tom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		return Nota.semitom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return Nota.tom(getToVI());
	}
	
}
