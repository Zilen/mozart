package etc;

public class Teste {
	public static void main(String[] args) {
		System.out.println(pegaValor(11));
	}

	static int tamanho = 4;
	private static int pegaValor(int i) {
		if(i < tamanho) {
			return 1;
		} else {
			return 1+pegaValor(i-tamanho);
		}
	}
}
