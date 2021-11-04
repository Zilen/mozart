package entitade.escala;

import entitade.nota.Nota;

public class EscalaArabeMenor extends Escala {

	public EscalaArabeMenor(Nota tonica) {
		super(tonica);
	}

	@Override
	protected Nota getToII() {
		return Nota.tom(getI().getNota());
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

	@Override
	public String getNome() {
		return "Escala Arábica Menor";
	}
	
}
