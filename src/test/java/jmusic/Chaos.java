package jmusic;

import jm.JMC;
import jm.util.*;
import jm.music.data.*;
import jm.midi.*;

/**
 * A short example which generates a chaotic chromatic melody
 * and writes to a MIDI file called chaos.mid
 * Algorithm taken from "Computer Music" by Dodge and Jerse, P.373.
 * @author Andrew Brown
 */
public final class Chaos implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Chaos", 130);
		Part inst = new Part("Piano", PIANO, 0);
		Phrase phr = new Phrase(0.0);
		double xold = 0.0; // initial x position
		double x, y; // temp variables
		double yold = 0.0; // initial y position
		
		//---------------
		// Do chaotic things
		//----------------
		double a = Math.random() * (1.5 - 1.3) + 1.3;// first constant. For oscillation try 1.04
		double b = 0.3; //second constant. For oscillation try 0.3
		
		// create a phrase of chaotically pitched quavers over a limited MIDI range.
		for(short i=0;i<48;i++){
			x = 1 + yold - a * xold * xold;
			y = b * xold;
			// map the x value across a few octaves
			Note note = new Note((int)(x*36)+48, Q);
			phr.addNote(note);
			xold = x;
			yold = y;
		}
		inst.addPhrase(phr);
		
		// add the part that to a score
		score.addPart(inst);
		
		// create a MIDI file of the score
		View.show(score);
	}
}