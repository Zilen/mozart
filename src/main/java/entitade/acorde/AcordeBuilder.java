package entitade.acorde;

import entitade.escala.Escala;
import entitade.nota.Nota;

public class AcordeBuilder {

	public static Acorde build(Escala escala, Nota nota) {
		return build(escala, nota, null);
	}
	public static Acorde build(Escala escala, Nota nota, TipoAcorde tipoAcorde) {
		
		int posicao = 0;
		for(Nota n : escala.getNotas()) {
			posicao++;
			if(n.equals(nota)) {
				break;
			}
		}
		
		ListaNota triade = new ListaNota(3, posicao, TipoAcorde.TRIADE);
		triade.add(nota);
		triade.add(escala.relativa(nota, 3));
		triade.add(escala.relativa(nota, 5));
		ListaNota setima = new ListaNota(4, posicao, TipoAcorde.SETIMA);
		triade.forEach(n -> { setima.add(n); }); 
		setima.add(escala.relativa(nota, 7));
		ListaNota sexta = new ListaNota(4, posicao, TipoAcorde.SEXTA);
		triade.forEach(n -> { sexta.add(n); }); 
		sexta.add(escala.relativa(nota, 6));
		ListaNota nona = new ListaNota(5, posicao, TipoAcorde.NONA);
		setima.forEach(n -> { nona.add(n); }); 
		nona.add(escala.relativa(nota, 9));
		ListaNota decimaTerceira = new ListaNota(6, posicao, TipoAcorde.DECIMA_TERCEIRA);
		nona.forEach(n -> { decimaTerceira.add(n); }); 
		decimaTerceira.add(escala.relativa(nota, 13));
		ListaNota sus = new ListaNota(3, posicao, TipoAcorde.SUSPENSO);
		sus.add(nota);
		sus.add(escala.relativa(nota, 4));
		ListaNota sus7 = new ListaNota(4, posicao, TipoAcorde.SUSPENSO_7);
		sus.forEach(n -> {sus7.add(n);});
		sus7.add(escala.relativa(nota, 7));
		sus.add(escala.relativa(nota, 5));
		
		return  new Acorde(escala, nota, triade, setima, sexta, nona, decimaTerceira, sus, sus7, tipoAcorde, posicao);
	}
	
}
