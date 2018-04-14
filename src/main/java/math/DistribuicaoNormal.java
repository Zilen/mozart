package math;

public class DistribuicaoNormal {
	public static Double getY(Double x, Double m, Double s) {
		double pi = Math.PI;
		double e = Math.E;
		
		Double parte1 = (1.0 / (Math.sqrt(2*pi) * s))*e;
		
		Double parte2 =  (- Math.pow((x - m), 2)) / (2* Math.pow(s, 2));
		
		return Math.pow(parte1, parte2);
	}
	
	
	public static void main(String[] args) {
		for(Double i = 0.0; i < 10.0; i++) {
			System.out.println(i.toString().replace(".", ",")+"@"+getY(i, 4.2, 0.8).toString().replace(".", ","));
		}
	}
}
