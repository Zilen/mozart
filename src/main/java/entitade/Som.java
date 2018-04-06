package entitade;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import jm.constants.Pitches;

public enum Som {
	B0  (31.0  , Nota.B ,  Pitches.B0),
	C1  (33.0  , Nota.C ,  Pitches.C1 ),
	CS1 (35.0  , Nota.Cs,  Pitches.CS1),
	D1  (37.0  , Nota.D ,  Pitches.D1 ),
	DS1 (39.0  , Nota.Ds,  Pitches.DS1),
	E1  (41.0  , Nota.E ,  Pitches.E1 ),
	F1  (44.0  , Nota.F ,  Pitches.F1 ),
	FS1 (46.0  , Nota.Fs,  Pitches.FS1),
	G1  (49.0  , Nota.G ,  Pitches.G1 ),
	GS1 (52.0  , Nota.Gs,  Pitches.GS1),
	A1  (55.0  , Nota.A ,  Pitches.A1 ),
	AS1 (58.0  , Nota.As,  Pitches.AS1),
	B1  (62.0  , Nota.B ,  Pitches.B1 ),
	C2  (65.0  , Nota.C ,  Pitches.C2 ),
	CS2 (69.0  , Nota.Cs,  Pitches.CS2),
	D2  (73.0  , Nota.D ,  Pitches.D2 ),
	DS2 (78.0  , Nota.Ds,  Pitches.DS2),
	E2  (82.0  , Nota.E ,  Pitches.E2 ),
	F2  (87.0  , Nota.F ,  Pitches.F2 ),
	FS2 (93.0  , Nota.Fs,  Pitches.FS2),
	G2  (98.0  , Nota.G ,  Pitches.G2 ),
	GS2 (104.0 , Nota.Gs,  Pitches.GS2),
	A2  (110.0 , Nota.A ,  Pitches.A2 ),
	AS2 (117.0 , Nota.As,  Pitches.AS2),
	B2  (123.0 , Nota.B ,  Pitches.B2 ),
	C3  (131.0 , Nota.C ,  Pitches.C3 ),
	CS3 (139.0 , Nota.Cs,  Pitches.CS3),
	D3  (147.0 , Nota.D ,  Pitches.D3 ),
	DS3 (156.0 , Nota.Ds,  Pitches.DS3),
	E3  (165.0 , Nota.E ,  Pitches.E3 ),
	F3  (175.0 , Nota.F ,  Pitches.F3 ),
	FS3 (185.0 , Nota.Fs,  Pitches.FS3),
	G3  (196.0 , Nota.G ,  Pitches.G3 ),
	GS3 (208.0 , Nota.Gs,  Pitches.GS3),
	A3  (220.0 , Nota.A ,  Pitches.A3 ),
	AS3 (233.0 , Nota.As,  Pitches.AS3),
	B3  (247.0 , Nota.B ,  Pitches.B3 ),
	C4  (262.0 , Nota.C ,  Pitches.C4 ),
	CS4 (277.0 , Nota.Cs,  Pitches.CS4),
	D4  (294.0 , Nota.D ,  Pitches.D4 ),
	DS4 (311.0 , Nota.Ds,  Pitches.DS4),
	E4  (330.0 , Nota.E ,  Pitches.E4 ),
	F4  (349.0 , Nota.F ,  Pitches.F4 ),
	FS4 (370.0 , Nota.Fs,  Pitches.FS4),
	G4  (392.0 , Nota.G ,  Pitches.G4 ),
	GS4 (415.0 , Nota.Gs,  Pitches.GS4),
	A4  (440.0 , Nota.A ,  Pitches.A4 ),
	AS4 (466.0 , Nota.As,  Pitches.AS4),
	B4  (494.0 , Nota.B ,  Pitches.B4 ),
	C5  (523.0 , Nota.C ,  Pitches.C5 ),
	CS5 (554.0 , Nota.Cs,  Pitches.CS5),
	D5  (587.0 , Nota.D ,  Pitches.D5 ),
	DS5 (622.0 , Nota.Ds,  Pitches.DS5),
	E5  (659.0 , Nota.E ,  Pitches.E5 ),
	F5  (698.0 , Nota.F ,  Pitches.F5 ),
	FS5 (740.0 , Nota.Fs,  Pitches.FS5),
	G5  (784.0 , Nota.G ,  Pitches.G5 ),
	GS5 (831.0 , Nota.Gs,  Pitches.GS5),
	A5  (880.0 , Nota.A ,  Pitches.A5 ),
	AS5 (932.0 , Nota.As,  Pitches.AS5),
	B5  (988.0 , Nota.B ,  Pitches.B5 ),
	C6  (1047.0, Nota.C ,  Pitches.C6 ),
	CS6 (1109.0, Nota.Cs,  Pitches.CS6),
	D6  (1175.0, Nota.D ,  Pitches.D6 ),
	DS6 (1245.0, Nota.Ds,  Pitches.DS6),
	E6  (1319.0, Nota.E ,  Pitches.E6 ),
	F6  (1397.0, Nota.F ,  Pitches.F6 ),
	FS6 (1480.0, Nota.Fs,  Pitches.FS6),
	G6  (1568.0, Nota.G ,  Pitches.G6 ),
	GS6 (1661.0, Nota.Gs,  Pitches.GS6),
	A6  (1760.0, Nota.A ,  Pitches.A6 ),
	AS6 (1865.0, Nota.As,  Pitches.AS6),
	B6  (1976.0, Nota.B ,  Pitches.B6 ),
	C7  (2093.0, Nota.C ,  Pitches.C7 ),
	CS7 (2217.0, Nota.Cs,  Pitches.CS7),
	D7  (2349.0, Nota.D ,  Pitches.D7 ),
	DS7 (2489.0, Nota.Ds,  Pitches.DS7),
	E7  (2637.0, Nota.E ,  Pitches.E7 ),
	F7  (2794.0, Nota.F ,  Pitches.F7 ),
	FS7 (2960.0, Nota.Fs,  Pitches.FS7),
	G7  (3136.0, Nota.G ,  Pitches.G7 ),
	GS7 (3322.0, Nota.Gs,  Pitches.GS7),
	A7  (3520.0, Nota.A ,  Pitches.A7 ),
	AS7 (3729.0, Nota.As,  Pitches.AS7),
	B7  (3951.0, Nota.B ,  Pitches.B7 ),
	C8  (4186.0, Nota.C ,  Pitches.C8 ),
	CS8 (4435.0, Nota.Cs,  Pitches.CS8),
	D8  (4699.0, Nota.D ,  Pitches.D8 ),
	DS8 (4978.0, Nota.Ds,  Pitches.DS8);

	private Double frequencia;
	private Nota nota;
	private Integer pitch;
	private static Random random = new Random();

	private Som(Double frequencia, Nota nota, int pitch) {
		this.frequencia = frequencia;
		this.nota = nota;
		this.pitch = pitch;
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

	public void setFrequencia(Double frequencia) {
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
		};
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


	public Integer getPitch() {
		return pitch;
	}


}
