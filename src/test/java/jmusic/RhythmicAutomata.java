package jmusic;


import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.JMC;
import jm.constants.Durations;
import jm.util.*;
import jm.music.data.*;
import jm.midi.*;
/**
* This class shows a simple one dimensional 
* Cellular Automata that is applied to generate an
* evolutionary series of bars each with 16 pulses.
* @author Andrew Brown
*/
public class RhythmicAutomata {
	  /* declare the empty bar arrays */
    int barLength = 16;
    int[] bar = new int[barLength];
    int[] tempBar = new int[barLength];
    /* Declare the jMusic score and parts */
    Part part1 = new Part("Hats", 0, 9);
    Part part2 = new Part("Rim Shot", 0, 9);
    Part part3 = new Part("Claps", 0, 9);
    Score score = new Score("AlgoRhythm", 84);
    
    /** 
    * The program starts here first 
    */
    public static void main(String[] args) {
        new RhythmicAutomata();
    }
    
    /** 
    * Constructor 
    */
    public RhythmicAutomata() {
        /* fill array */
        initialise();
        makeMusic(part1, 42);
        
        /* calc next array */
        for(int i=0; i<23; i++) {
            nextBar();
            makeMusic(part1, 42);
            printBar();
        }
        
        /* fill array */
        initialise();
        makeMusic(part2, 37);
        
        /* calc next array */
        for(int i=0; i<23; i++) {
            nextBar();
            makeMusic(part2, 37);
            printBar();
        }
        
        /* fill array */
        initialise();
        makeMusic(part3, 39);
        
        /* calc next array */
        for(int i=0; i<23; i++) {
            nextBar();
            makeMusic(part3, 39);
            printBar();
        }
        
        score.addPart(part1);
        score.addPart(part2);
        score.addPart(part3);
        
        /* save as a MIDI file */
//        Write.midi(score, "RhythmicAutomata.mid");
        
        View.show(score);
    }
    
    /**
    * Fill the bar with randomly set values
    */
    private void initialise() {
        System.out.println();
        System.out.println("====== Initialising automata array ======");
        for(int i=0; i<barLength; i++) {
            bar[i] = (int)(Math.random() * 2);
        }
        printBar();
    }
    
    /**
    * Display the bar values on the command line
    */
    private void printBar() {
        for (int i=0; i<barLength; i++) {
            System.out.print(bar[i] + " ");
        }
        System.out.println();
    }
    
    /**
    * Apply the rules to generate the next bar
    */
    private void nextBar() {
        int score = 0;
        /* calculate the number of neighbours */
        for(int i=0; i<barLength; i++) {
            for(int j=1; j<3; j++) {
                if (i-j > 0) score += bar[i - j];
                if (i+j < barLength) score += bar[i +j];
            }
            /* apply the rules of evolution */
            if (score == 0) {
                if (bar[i] == 1) tempBar[i] = 0;
                else tempBar[i] = 1;
            }
            if (score == 1) tempBar[i] = bar[i];
            if (score == 2) tempBar[i] = bar[i];
            if (score == 3) {
                if (bar[i] == 1) tempBar[i] = 0;
                else tempBar[i] = 1;
            }
            if (score == 4) tempBar[i] = 0;
            /* reset score value for next index */
            score = 0;
        }
        /* shift new values in */
        bar = tempBar;
    }
    
    /**
    * Convert the bar array into a jMusic phrase
    * and add the phrase to the specified part.
    */
    private void makeMusic(Part p, int pitch) {
        Phrase phr = new Phrase();
        for (int i=0; i<barLength; i++) {
            if (bar[i] == 0) phr.addNote(new Note ( 0, Durations.SQ));
            else phr.addNote(new Note(pitch, Durations.SQ, (int)(Math.random() * 60 + 60)));
        }
        p.addPhrase(phr);
    }
}


// Try changing sounds

// Try changing tempo

// Try changing bar length

// Try adding another part

// Try capturing bars then playing in reverse order - going from cohesive -> random

// Try changing the rules

// Try making it take into account 3 neighbours each side rather than 2

// Try starting with composed patterns rather than random patterns