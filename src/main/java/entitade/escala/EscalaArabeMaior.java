package entitade.escala;

import entitade.nota.Nota;

public class EscalaArabeMaior extends Escala {

	public EscalaArabeMaior(Nota tonica) {
		super(tonica);
	}

	@Override
	protected Nota getToII() {
		return Nota.semitom(getI().getNota());
	}

	@Override
	protected Nota getToIII() {
		return Nota.tomSemitom(getToII());
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
		return Nota.semitom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return Nota.tomSemitom(getToVI());
	}

	@Override
	public String getNome() {
		return "Escala Arábica Maior";
	}
	
}
