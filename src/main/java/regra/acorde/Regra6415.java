package regra.acorde;

import java.util.Arrays;
import java.util.List;

import acao.acorde.AcordesAcao;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.escala.EscalaMaiorNatural;
import entitade.escala.EscalaMenorNatural;

public class Regra6415 extends RegraAcorde {


	private List<String> nomeEscala = Arrays.asList( 
			new String[]{ new EscalaMaiorNatural(null).getNome(), new EscalaMenorNatural(null).getNome() });
	
	@Override
	public Boolean isValid(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		boolean isEscalaMaior = nomeEscala.stream().anyMatch(n ->  n.equals(musica.getEscala().getNome()));
		
		ListaNota a = musica.getAcordes().size() >= 1 ? musica.getAcordes().get(musica.getAcordes().size() -1) : null; 
		ListaNota acordeAnterior = musica.getAcordes().size() >= 2 ? musica.getAcordes().get(musica.getAcordes().size() -2) : null; 
		ListaNota acordeAnterior2 = musica.getAcordes().size() >= 3 ? musica.getAcordes().get(musica.getAcordes().size() -3) : null; ;
		ListaNota acordeAnterior3 = musica.getAcordes().size() >= 4 ? musica.getAcordes().get(musica.getAcordes().size() -4) : null; ;
		boolean is6415 = this.consume(a, acordeAnterior, acordeAnterior2, acordeAnterior3);
		
		return isEscalaMaior && is6415;
	}

	private Boolean consume(ListaNota a, ListaNota b, ListaNota c, ListaNota d) {
		boolean retorno = false;
		
		if(a != null && c != null && b != null && c.getPosicaoEscala().equals(6) && b.getPosicaoEscala().equals(4) && a.getPosicaoEscala().equals(1)) {
			retorno = true;
		}
		
		if(a != null && b != null && b.getPosicaoEscala().equals(6) && a.getPosicaoEscala().equals(4)) {
			retorno = true;
		}
		
		if(a != null && a.getPosicaoEscala().equals(6)) {
			retorno = true;
		}
		d = c;
		c = b;
		b = a;
		return retorno;
	}

	@Override
	public void executar(List<AcordesAcao> acordesAcao, Musica musica, Integer iteration) {
		ListaNota acordeAnterior = musica.getAcordes().get(musica.getAcordes().size()-1);
		if(acordeAnterior.getPosicaoEscala().equals(6)) {
			processor.adicionarChance(3, acordesAcao, acordesAcao.get(3).getChanceInversa() * 0.20);
		}
		if(acordeAnterior.getPosicaoEscala().equals(4)) {
			processor.adicionarChance(0, acordesAcao, acordesAcao.get(0).getChanceInversa() * 0.60);
		}
		if(acordeAnterior.getPosicaoEscala().equals(1)) {
			processor.adicionarChance(4, acordesAcao, acordesAcao.get(4).getChanceInversa() * 0.90);
		}
	}

}
