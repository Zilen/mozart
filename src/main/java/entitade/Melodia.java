package entitade;

import entitade.escala.Escala;
import entitade.nota.NotaTocada;

import java.util.List;

public interface Melodia {
    List<NotaTocada> getMelodia();
    Escala getEscala();
}
