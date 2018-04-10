package Utils;

import java.util.Random;

public class Rand {
	private static Random random = new Random();
	
	public static Double nextDouble() {
		return random.nextDouble();
	}
	
	public static Random get() {
		return random;
	}

	public static int nextInt(int size) {
		return random.nextInt(size);
	}
	
	public static int between(int min, int max) {
		return min + (int)(random.nextDouble() * ((max - min) + 1));
	}
}
