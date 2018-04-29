package regra.melodia;

import acao.melodia.FraseAcao;
import acao.melodia.MelodiaAcaoProcessor;
import entitade.Frase;
import regra.Regra;

public abstract class RegraMelodia implements Regra<FraseAcao> {

	protected MelodiaAcaoProcessor processor;

	protected Frase frase;
	
	public Frase getFrase() {
		return frase;
	}

	public MelodiaAcaoProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(MelodiaAcaoProcessor processor) {
		this.processor = processor;
	}

}
