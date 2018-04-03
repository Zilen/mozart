package entitade;

public class EscalaCigana extends Escala {

	public EscalaCigana(Nota t�nica) {
		super(t�nica);
	}

	@Override
	protected Nota getToII() {
		return Nota.tom(getI());
	}

	@Override
	protected Nota getToIII() {
		return Nota.semitom(getToII());
	}

	@Override
	protected Nota getToIV() {
		return Nota.tomSemitom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.semitom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		return Nota.semitom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return Nota.tomSemitom(getToVI());
	}
	
}
