package entitade.escala;

import entitade.nota.Nota;

public class EscalaPentatonica extends Escala {

	public EscalaPentatonica(Nota tonica) {
		super(tonica);
	}

	@Override
	protected Nota getToII() {
		return Nota.tomSemitom(getI().nota());
	}

	@Override
	protected Nota getToIII() {
		return Nota.tom(getToII());
	}

	@Override
	protected Nota getToIV() {
		return Nota.tom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.tomSemitom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		return null;
	}

	@Override
	protected Nota getToVII() {
		return null;
	}

	@Override
	public String getNome() {
		return "Escala Pentatonica Menor";
	}

	@Override
	public Integer getNumeroDeNotas() {
		return 5;
	}
}
