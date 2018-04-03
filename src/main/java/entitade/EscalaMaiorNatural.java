package entitade;

public class EscalaMaiorNatural extends Escala {

	public EscalaMaiorNatural(Nota tônica) {
		super(tônica);
	}

	@Override
	Nota getII() {
		return Nota.tom(getI());
	}

	@Override
	Nota getIII() {
		return Nota.tom(getII());
	}

	@Override
	Nota getIV() {
		return Nota.semitom(getIII());
	}

	@Override
	Nota getV() {
		return Nota.tom(getIV());
	}

	@Override
	Nota getVI() {
		return Nota.tom(getV());
	}

	@Override
	Nota getVII() {
		return Nota.tom(getIV());
	}
	
}
