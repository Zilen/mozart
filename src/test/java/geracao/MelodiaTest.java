package geracao;

import acao.melodia.MelodiaAcaoProcessor;
import entitade.Melodia;
import entitade.acorde.AcordeBuilder;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import entitade.escala.Escalas;
import entitade.nota.Nota;
import exception.AcordeInvalidoException;
import regra.melodia.RegraMelodia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MelodiaTest {
    public static void main(String[] args) {
        MelodiaAcaoProcessor processor = new MelodiaAcaoProcessor(null);

        Escala escala = Escalas.MENOR_HARMONICA.get(Nota.A);
        List<ListaNota> acordes = new ArrayList<>();
        try {
            acordes.add(AcordeBuilder.build(escala, Nota.A).getNona());
            acordes.add(AcordeBuilder.build(escala, Nota.Fs).getSus());
            acordes.add(AcordeBuilder.build(escala, Nota.D).getSus7());
            acordes.add(AcordeBuilder.build(escala, Nota.E).getSexta());
        } catch (AcordeInvalidoException e) {
            e.printStackTrace();
        }
        Melodia melodia = processor.gerarMelodia(acordes, escala, 4, 4);

    }
}
