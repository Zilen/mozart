package regra.acorde;

import acao.AcaoProcessor;
import acao.acorde.AcordesAcao;
import regra.Regra;

public abstract class RegraAcorde implements Regra<AcordesAcao> {
	
	protected AcaoProcessor<AcordesAcao> processor;

	public AcaoProcessor<AcordesAcao> getProcessor() {
		return processor;
	}

	public void setProcessor(AcaoProcessor<AcordesAcao> processor) {
		this.processor = processor;
	}
}
