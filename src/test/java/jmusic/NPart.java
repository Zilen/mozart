package jmusic;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;
import jm.util.*;

/**
* This class is a support class for the Journey class.
* @author Andrew Brown
*/

public class NPart implements JMC {
	private Part part;
	private int[] pitches = {C4, E4, G4, A4, D4, F4, E4};
	private double[] rhythms = {Q, Q, Q, Q, Q, Q, C};
	private double partLength = 40.0;
	private double fadeInLength = 12.0;
	private double fadeOutLength = 12.0;
	private double nPartStartTime;
	private int panPosition = (int)(Math.random() * 127);
	
	public NPart(Part p) {
	    this.part = p;
	    p.setInstrument((int)(Math.random()*60));
	    nPartStartTime = (int)(Math.random() * 200) * SQ;
	    // make a pharse for this part
	    p.addPhrase(makePhrase());
	}
	
	private Phrase makePhrase() {
	    Phrase phr = new Phrase( nPartStartTime);
	    phr.addNoteList(pitches, rhythms);
	    phr.setPan(Math.random());
	    Mod.shuffle(phr);
	    Mod.cycle(phr, partLength);
	    Mod.fadeIn(phr, fadeInLength);
	    Mod.fadeOut(phr, fadeOutLength);
	    return phr;
	}
	    
}