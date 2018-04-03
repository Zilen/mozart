package entitade;

public class EscalaMenorNatural extends Escala {

	public EscalaMenorNatural(Nota tônica) {
		super(tônica);
	}

	@Override
	Nota getII() {
		return Nota.tom(getI());
	}

	@Override
	Nota getIII() {
		return Nota.semitom(getII());
	}

	@Override
	Nota getIV() {
		return Nota.tom(getIII());
	}

	@Override
	Nota getV() {
		return Nota.tom(getIV());
	}

	@Override
	Nota getVI() {
		return Nota.semitom(getV());
	}

	@Override
	Nota getVII() {
		return Nota.tom(getVI());
	}
	
}
