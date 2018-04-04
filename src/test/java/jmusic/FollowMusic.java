package jmusic;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.View;
import jm.util.Write;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class FollowMusic {
	public static void main(String[] args) {
		// repeat the whole compositional process serval times
		for(int j=0;j<1;j++){
		
			// create a score to hold the composition
			Score s = new Score("Follow Music Demo "+j);
			
			// create a phrase to hold the melody
			Phrase phr = new Phrase(0.0);
			
			// create a random walk melody
			int pitch = 60;
			for(int i=0;i<60;i++){
				Note n = new Note(pitch,0.5, (int)(Math.random()*127));
				phr.addNote(n);
				pitch += (int)(Math.random()*10-5);
				System.out.println(pitch);
			}
			
			// copy and repeat the melody numerous times
			for(int i=0;i<9;i++){
				Part p = new Part("inst 1",  jm.constants.ProgramChanges.XYLOPHONE, i);
				Phrase tempPhrase = new Phrase();
				tempPhrase = phr.copy();
//				tempPhrase.setStartTime((double)i/4.0+i*2);
				p.addPhrase(tempPhrase);
				s.addPart(p);
			}
			
			// save a MIDI file of the result
//			Write.midi(s, "FollowMusic"+j+".mid");
			
			// display a visual score of the result
			View.show(s, j*10, j*20);
		}
	}
}
