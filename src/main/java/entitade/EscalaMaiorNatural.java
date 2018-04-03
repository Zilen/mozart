package entitade;

public class EscalaMaiorNatural extends Escala {

	public EscalaMaiorNatural(Nota tonica) {
		super(tonica);
	}

	@Override
	protected Nota getToII() {
		return Nota.tom(getI());
	}

	@Override
	protected Nota getToIII() {
		return Nota.tom(getToII());
	}

	@Override
	protected Nota getToIV() {
		return Nota.semitom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.tom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		return Nota.tom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return Nota.tom(getToVI());
	}
	
}
