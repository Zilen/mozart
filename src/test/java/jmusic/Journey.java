package jmusic;
import jm.JMC;
import jm.music.data.*;
import jm.util.View;
import jm.util.Play;


/**
* This class creates a collage of similar parts, each
* of which may overlap and be rhythmicaly juxtaposed.
* The phrase repetition is in a minimalist style.
* The creation of parts is handled by the NPart class.
* @author Andrew Brown
*/

public class Journey implements JMC {
	private Score score = new Score();
	
	public static void main(String[] args) {
		new Journey();
	}
	
	public Journey() {
	    // create new parts
	    for(int i=0; i<8;i++) {
	        new NPart(newPart());
      }
      
      // display the score data on screen
	    View.print(score);
	    
	    // play the score
	    Play.midi(score);	
	    

	}
	
	private Part newPart() {
	    Part p = new Part();
	    p.setChannel(score.size());
	    score.addPart(p);
	    return p;
	}
}