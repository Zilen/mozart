package jmusic;

import static jm.constants.Durations.C;
import static jm.constants.Durations.M;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.PhraseMatrix;
import jm.util.View;
import jm.util.Write;



public class MarkovTest {
	public static void main(String[] args){
		Phrase marysLamb = new Phrase();
	    int[] p = {64,62,60,62,64,64,64,62,62,62,64,67,67,64,62,60,62,64,64,64,64,62,62,64,62,60};	
		double[] r = {C,C,C,C,C,C,M,C,C,M,C,C,M,C,C,C,C,C,C,C,C,C,C,C,C,M};
		int[] d = {80,70,60,70,80,80,80,70,70,70,80,100,100,80,70,60,70,80,80,80,80,70,70,80,70,60};
		marysLamb.addNoteList(p,r,d);
		int markovDepth = 2;
		PhraseMatrix matrix = new PhraseMatrix(marysLamb,markovDepth);
		Phrase myLamb = matrix.generate(true,true,true,20);
		Score scr = new Score("MarysLamb");
		Part part = new Part();
		part.addPhrase(myLamb);
		scr.addPart(part);
//		Write.midi(scr);
		View.show(scr);
	}
}
