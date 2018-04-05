package jFugue;

import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;

public class TryThis {
    public static void main(String[] args) {
        new Player().play(new ChordProgression("I IV vi V").eachChordAs("$!i $!i Ri $!i"), new Rhythm().addLayer("..X...X...X...XO"));
        System.out.println("!");
    }
}