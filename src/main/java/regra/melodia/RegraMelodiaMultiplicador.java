package regra.melodia;

public abstract class RegraMelodiaMultiplicador extends RegraMelodia {

	protected double multiplicador;

	public RegraMelodiaMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}
}
