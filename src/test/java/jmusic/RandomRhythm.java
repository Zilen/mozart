package jmusic;


import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class RandomRhythm implements JMC{
	public static void main(String[] args){
	       Score score = new Score("JMDemo - Random Rhythm");
	       Part inst = new Part("Snare", 1, 9);
	       Phrase phr = new Phrase(0.0);
	       
	       for(short i=0;i<24;i++){
               Note note = new Note(40, Math.random()*4);
               phr.addNote(note);
       }
	       inst.addPhrase(phr);
		    score.addPart(inst);
		    
		    Play.midi(score);
//		    Write.midi(score, "randomRhythm.mid");
		    
	}
	
}