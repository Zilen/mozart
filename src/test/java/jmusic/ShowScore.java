package jmusic;


import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.View;
import jm.util.Write;

/**
 * A short example which generates a chromatic fractal melody
 * and writes it to a MIDI file called fractal.mid
 * @author Andrew Brown
 * Fractal algorithm by R. F. Voss as cited in Dodge and Jerse "Computer Music"
 * p.369.
 */
public final class ShowScore implements JMC{
	public static void main(String[] args){
		Score s = new Score("JMDemo - Show Fractal");
		Part p = new Part("Piano", PIANO, 0);
		Phrase phr = new Phrase(0.0);
		float sum;
		float[] rg = new float[16];
		int k, kg, ng, threshold;
		int np = 1;
		int nbits = 1;
		int npts = 48; //number of notes
		float nr = (float)(npts);

		nr = nr/2;

		// create a phrase of fractal pitches quavers over the full MIDI
                // range.
		System.out.println("Calculating fractal melody. . .");

		while (nr > 1) {
			nbits++;
			np = 2 * np;
			nr = nr/2;
		}

		for(kg=0; kg<nbits; kg++) {
			rg[kg] = (float)(Math.random());
		}

		for(k=0; k<npts; k++) {
			threshold = np;
			ng = nbits;
			while(k%threshold != 0) {
				ng--;
				threshold = threshold / 2;
			}
			sum = 0;
			for(kg=0; kg<nbits; kg++) {
				if(kg<ng) {rg[kg]=(float)(Math.random());}
				sum += rg[kg];
			}
			Note note = new Note((int)(sum/nbits*127),
                                             (float)((int)(Math.random()*8)/2));
			phr.addNote(note);
		}

		// add the phrase to a part and that part to the score
		p.addPhrase(phr);
		s.addPart(p);

		//display score using ShowScore
		View.show(s);

		Write.midi(s, "ShowFractal.mid");
	}
}