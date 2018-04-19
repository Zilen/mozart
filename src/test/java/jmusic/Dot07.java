package jmusic;
import jm.JMC;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;
import jm.util.View;
import jm.util.Write;
 
public class Dot07 implements JMC {
    private Score aScore = new Score("Added Hats");
    private int partCounter = 0;
    
    public static void main(String[] args) { 
        new Dot07();
    }
    
    // the constructor method
    public Dot07() {
        // musical material
        double[] phraseOneData = {C4, QUARTER_NOTE};
        double[] phraseTwoData = {REST, EIGHTH_NOTE, E4, 
            EIGHTH_NOTE, REST, QUARTER_NOTE};        
        double[] phraseThreeData = {REST, QUARTER_NOTE, F4, 
            EIGHTH_NOTE, REST, EIGHTH_NOTE};
        double[] phraseFourData = {FS2, SIXTEENTH_NOTE};
        
        // arrangement and orchestration
        notesToPart( phraseOneData, 0.0, 48, CLARINET, 0);
        notesToPart( phraseTwoData, 4.0, 9, FLUTE, 1);
        notesToPart( phraseThreeData, 8.0, 7, NYLON_GUITAR, 2);
        notesToPart( phraseTwoData, 30.0, 7, FLUTE, 3);
        notesToPart( phraseThreeData, 32.0, 7, HORN, 4);
        // add the hihats
        notesToPart( phraseFourData, 2.0 ,190, 0, 9);
        
        // add accents
        Mod.accents(aScore, 2.0);
        
        // specify the tempo
        aScore.setTempo(140.0);
        
        // view the score
        View.sketch(aScore);
        
        // play the score with QuickTime
//        QTPlayer.display(aScore);
        
        // save the score as a MIDI file
        Write.midi(aScore, "Dot07.mid");
    }
    
    private void notesToPart(double[] notes, double startTime, 
             int repeats, int instrument, int channel) {
        // create a new phrase from the notes and loop it
        Phrase aPhrase = new Phrase(startTime);
        aPhrase.addNoteList(notes);
        Mod.repeat(aPhrase, repeats);
        // create a new part and add the phrase to it
        Part aPart = new Part("Part "+partCounter, instrument, channel);
        aPart.addPhrase(aPhrase);
        // keep track of how many parts have been created
        partCounter++;
        // add the part to the score
        aScore.addPart(aPart);
 
    }
}