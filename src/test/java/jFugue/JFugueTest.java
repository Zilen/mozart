package jFugue;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class JFugueTest {
	public static void main(String[] args) {
		Player player = new Player();
		Pattern p3 = new Pattern("C D E F G A B");
//		player.play("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq   V1 I[Flute] Rw | Rw | GmajQQQ CmajQ");
		
		Pattern p1 = new Pattern("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq");
	    Pattern p2 = new Pattern("V1 I[Flute] Rw     | Rw     | GmajQQQ  CmajQ");
	    player.play(p1, p2, p3);
	}
}
