package escala;

import java.util.ArrayList;
import java.util.List;

import acao.melodia.MelodiaAcaoProcessor;
import entitade.Musica;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.escala.Escalas;
import entitade.nota.Nota;
import entitade.nota.Som;
import implementacao.JMusic;

public class MusicaTeste {
	public static void main(String[] args) {
		Escala escala = Escalas.MENOR_NATURAL.get(Nota.Fs);
		List<ListaNota> acordes = new ArrayList<ListaNota>();
		
		for(int i =0; i <3 ; i++) {
			acordes.add(escala.getIII().getAcorde().getNona());
			acordes.add(escala.getI().getAcorde().getNona());
			acordes.add(escala.getVII().getAcorde().getNona());
			acordes.add(escala.getVI().getAcorde().getNona());
		}
		
		
		final Integer tempoPorCompasso = 4;
		Integer qtdCompassos =12;
		Integer tempo = 20;
		boolean isArpegio = false;
		Som notaBase = Som.A3;
		Som notaMelodia = Som.FS5;
		boolean notasForaDaEscala = false;
		Musica musica = new Musica(escala, tempo, isArpegio, notaBase, notaMelodia,  tempoPorCompasso, qtdCompassos, notasForaDaEscala);
		musica.setAcordes(acordes);
		new MelodiaAcaoProcessor(null).calcular(musica);
		JMusic.render(musica);
		
	}
}
