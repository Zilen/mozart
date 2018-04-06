package entitade;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Som {
	B0  (31  ,  Nota.B ),
	C1  (33  , Nota.C   ),
	CS1 (35  , Nota.Cs  ),
	D1  (37  , Nota.D   ),
	DS1 (39  , Nota.Ds  ),
	E1  (41  , Nota.E   ),
	F1  (44  , Nota.F   ),
	FS1 (46  , Nota.Fs  ),
	G1  (49  , Nota.G   ),
	GS1 (52  , Nota.Gs  ),
	A1  (55  , Nota.A   ),
	AS1 (58  , Nota.As  ),
	B1  (62  , Nota.B   ),
	C2  (65  , Nota.C   ),
	CS2 (69  , Nota.Cs  ),
	D2  (73  , Nota.D   ),
	DS2 (78  , Nota.Ds  ),
	E2  (82  , Nota.E   ),
	F2  (87  , Nota.F   ),
	FS2 (93  , Nota.Fs  ),
	G2  (98  , Nota.G   ),
	GS2 (104 , Nota.Gs  ),
	A2  (110 , Nota.A   ),
	AS2 (117 , Nota.As  ),
	B2  (123 , Nota.B   ),
	C3  (131 , Nota.C   ),
	CS3 (139 , Nota.Cs  ),
	D3  (147 , Nota.D   ),
	DS3 (156 , Nota.Ds  ),
	E3  (165 , Nota.E   ),
	F3  (175 , Nota.F   ),
	FS3 (185 , Nota.Fs  ),
	G3  (196 , Nota.G   ),
	GS3 (208 , Nota.Gs  ),
	A3  (220 , Nota.A   ),
	AS3 (233 , Nota.As  ),
	B3  (247 , Nota.B   ),
	C4  (262 , Nota.C   ),
	CS4 (277 , Nota.Cs  ),
	D4  (294 , Nota.D   ),
	DS4 (311 , Nota.Ds  ),
	E4  (330 , Nota.E   ),
	F4  (349 , Nota.F   ),
	FS4 (370 , Nota.Fs  ),
	G4  (392 , Nota.G   ),
	GS4 (415 , Nota.Gs  ),
	A4  (440 , Nota.A   ),
	AS4 (466 , Nota.As  ),
	B4  (494 , Nota.B   ),
	C5  (523 , Nota.C   ),
	CS5 (554 , Nota.Cs  ),
	D5  (587 , Nota.D   ),
	DS5 (622 , Nota.Ds  ),
	E5  (659 , Nota.E   ),
	F5  (698 , Nota.F   ),
	FS5 (740 , Nota.Fs  ),
	G5  (784 , Nota.G   ),
	GS5 (831 , Nota.Gs  ),
	A5  (880 , Nota.A   ),
	AS5 (932 , Nota.As  ),
	B5  (988 , Nota.B   ),
	C6  (1047, Nota.C   ),
	CS6 (1109, Nota.Cs  ),
	D6  (1175, Nota.D   ),
	DS6 (1245, Nota.Ds  ),
	E6  (1319, Nota.E   ),
	F6  (1397, Nota.F   ),
	FS6 (1480, Nota.Fs  ),
	G6  (1568, Nota.G   ),
	GS6 (1661, Nota.Gs  ),
	A6  (1760, Nota.A   ),
	AS6 (1865, Nota.As  ),
	B6  (1976, Nota.B   ),
	C7  (2093, Nota.C   ),
	CS7 (2217, Nota.Cs  ),
	D7  (2349, Nota.D   ),
	DS7 (2489, Nota.Ds  ),
	E7  (2637, Nota.E   ),
	F7  (2794, Nota.F   ),
	FS7 (2960, Nota.Fs  ),
	G7  (3136, Nota.G   ),
	GS7 (3322, Nota.Gs  ),
	A7  (3520, Nota.A   ),
	AS7 (3729, Nota.As  ),
	B7  (3951, Nota.B   ),
	C8  (4186, Nota.C   ),
	CS8 (4435, Nota.Cs  ),
	D8  (4699, Nota.D   ),
	DS8 (4978, Nota.Ds  );

	private Integer frequencia;
	private Nota nota;
	private static Random random = new Random();

	private Som(Integer frequencia, Nota nota) {
		this.frequencia = frequencia;
		this.nota = nota;
	}


	public static Som aleatorio(Nota nota) {
		while(true) {
			Som s = values()[random.nextInt(88 - 0 + 1) + 0];
			if (s.getNota().equals(nota)) {
				return s;
			}
		}
	}


	public Double getFrequencia() {
		return frequencia.doubleValue();
	}


	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}


	public Nota getNota() {
		return nota;
	}


	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public static Som get(Double frequencia) {
		Som retorno = null;
		for(Som s : values()) {
			if (s.getFrequencia().doubleValue() >= frequencia) {
				retorno = s;
				break;
			}
		}
		 return retorno;
	}
	
	public static List<Som> intervalo(Escala escala, Som base) {
		Double constante = 2.3;
		return intervalo(escala, get(base.getFrequencia()/constante), get(base.getFrequencia()*(constante)));
	}
	public static List<Som> intervalo(Escala escala, Som inicio, Som fim) {
		return Arrays.asList(values()).stream().filter(s -> {
			return (s.getFrequencia() <  fim.getFrequencia() && s.getFrequencia() > inicio.getFrequencia()) && escala.pertence(s);
		}).collect(Collectors.toList());
	}


}
