package entitade;

public class EscalaCigana extends Escala {

	public EscalaCigana(Nota tônica) {
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
		return Nota.tomSemitom(getIII());
	}

	@Override
	Nota getV() {
		return Nota.semitom(getIV());
	}

	@Override
	Nota getVI() {
		return Nota.semitom(getV());
	}

	@Override
	Nota getVII() {
		return Nota.tomSemitom(getVI());
	}
	
}
