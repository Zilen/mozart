package entitade.escala;

import entitade.nota.Nota;

public class EscalaPentaBlues extends Escala {

	public EscalaPentaBlues(Nota tonica) {
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
		return Nota.semitom(getToIII());
	}

	@Override
	protected Nota getToV() {
		return Nota.semitom(getToIV());
	}

	@Override
	protected Nota getToVI() {
		return Nota.tomSemitom(getToV());
	}

	@Override
	protected Nota getToVII() {
		return null;
	}

	@Override
	public String getNome() {
		return "Escala PentaBlues";
	}

	@Override
	public Integer getNumeroDeNotas() {
		return 6;
	}
}
