package instrumento;

import entitade.nota.NotaTocada;
import jm.music.data.CPhrase;

public interface Tocar {
	
	public void adicionarNota(NotaTocada... nota);
	public void definirTimbre(Integer numeroTimbre);
	public void tocar();
}
