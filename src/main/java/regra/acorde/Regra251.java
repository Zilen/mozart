package regra.acorde;

import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.escala.EscalaMaiorNatural;
import entitade.nota.Nota;

public class Regra251 extends RegraAcorde {


	private Escala nomeEscala = new EscalaMaiorNatural(null);
	
	@Override
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		boolean isEscalaMaior = musica.getEscala().getNome().equals(nomeEscala.getNome());
		
		ListaNota a = musica.getAcordes().size() >= 1 ? musica.getAcordes().get(musica.getAcordes().size() -1) : null; 
		ListaNota acordeAnterior =  musica.getAcordes().size() >= 2 ? musica.getAcordes().get(musica.getAcordes().size() -2) : null; ; 
		ListaNota acordeAnterior2 =  musica.getAcordes().size() >= 3 ? musica.getAcordes().get(musica.getAcordes().size() -3) : null; ;
		boolean is251 = this.consume(a, acordeAnterior, acordeAnterior2);
		
		return isEscalaMaior && is251;
	}

	private Boolean consume(ListaNota a, ListaNota b, ListaNota c) {
		boolean retorno = false;
		if(a != null && b != null && b.getPosicaoEscala().equals(2) && a.getPosicaoEscala().equals(5)) {
			retorno = true;
		}
		if(a != null && a.getPosicaoEscala().equals(2)) {
			retorno = true;
		}
		c = b;
		b = a;
		return retorno;
	}

	@Override
	public void executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		ListaNota acordeAnterior = musica.getAcordes().get(musica.getAcordes().size()-1);
		if(acordeAnterior.getPosicaoEscala().equals(2)) {
			processor.adicionarChance(4, acordesAcao, acordesAcao.get(4).getChanceInversa() * 0.30);
		}
		if(acordeAnterior.getPosicaoEscala().equals(5)) {
			processor.adicionarChance(0, acordesAcao, acordesAcao.get(0).getChanceInversa() * 0.85);
		}
	}

	@Override
	public Integer getPosicaoPrimeiro() {
		return 2;
	}

	@Override
	public Integer getQuantidadeRepeticoes() {
		return 3;
	}

}
