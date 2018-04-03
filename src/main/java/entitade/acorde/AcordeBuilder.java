package entitade.acorde;

import java.util.ArrayList;
import java.util.List;

import entitade.Acorde;
import entitade.Escala;
import entitade.Nota;

public class AcordeBuilder {

	public static Acorde build(Escala escala, Nota nota) {
		
		List<Nota> triade = new ArrayList<Nota>(3);
		triade.add(nota);
		triade.add(escala.relativa(nota, 3));
		triade.add(escala.relativa(nota, 5));
		List<Nota> setima = new ArrayList<Nota>(4);
		triade.forEach(n -> { setima.add(n); }); 
		setima.add(escala.relativa(nota, 7));
		List<Nota> nona = new ArrayList<Nota>(5);
		setima.forEach(n -> { nona.add(n); }); 
		nona.add(escala.relativa(nota, 9));
		List<Nota> decimaTerceira = new ArrayList<Nota>(6);
		nona.forEach(n -> { decimaTerceira.add(n); }); 
		decimaTerceira.add(escala.relativa(nota, 13));
		List<Nota> sus = new ArrayList<Nota>(3);
		sus.add(nota);
		sus.add(escala.relativa(nota, 4));
		List<Nota> sus7 = new ArrayList<Nota>(4);
		sus.forEach(n -> {sus7.add(n);});
		sus7.add(escala.relativa(nota, 7));
		sus.add(escala.relativa(nota, 5));
		
		return  new Acorde(escala, nota, triade, setima, nona, decimaTerceira, sus, sus7);
	}
	
}
