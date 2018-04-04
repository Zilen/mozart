package instrumento;

import jm.music.data.Note;
import jm.util.Play;

public class Piano {
public static void main(String[] args) {
	
	Note la = new Note();
	
	la.setFrequency(440);
	
	Play.midi(la);
	
	la.setFrequency(554);
	
	Play.midi(la);
	
	la.setFrequency(659);
	
	Play.midi(la);
	
}
}

