package regra.acorde;

import acao.acorde.AcordesAcaoProcessor;
import regra.Regra;

public abstract class RegraAcorde implements Regra {
	
	protected AcordesAcaoProcessor processor;

	public AcordesAcaoProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(AcordesAcaoProcessor processor) {
		this.processor = processor;
	}

}
