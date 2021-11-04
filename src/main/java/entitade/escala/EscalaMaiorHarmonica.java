package entitade.escala;

import entitade.nota.Nota;

public class EscalaMaiorHarmonica extends Escala {

	public EscalaMaiorHarmonica(Nota tonica) {
		super(tonica);
	}

	@Override
	protected  Nota getToII() {
		return Nota.tom(getI().getNota());
	}

	@Override
	protected  Nota getToIII() {
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
		return Nota.semitom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return Nota.tomSemitom(getToVI());
	}

	@Override
	public String getNome() {
		return "Escala Maior Harmônica";
	}
	
}
