package entitade.nota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

import Utils.Rand;
import acao.Probabilidade;
import entitade.acorde.ListaNota;
import entitade.escala.Escala;
import jm.constants.Pitches;
import math.DistribuicaoNormal;

public enum Som {
	B0  (31.0  , Nota.B , 1,  Pitches.B0),
	C1  (33.0  , Nota.C , 2, Pitches.C1 ),
	CS1 (35.0  , Nota.Cs, 3,  Pitches.CS1),
	D1  (37.0  , Nota.D , 4,  Pitches.D1 ),
	DS1 (39.0  , Nota.Ds, 5,  Pitches.DS1),
	E1  (41.0  , Nota.E , 6,  Pitches.E1 ),
	F1  (44.0  , Nota.F , 7,  Pitches.F1 ),
	FS1 (46.0  , Nota.Fs, 8,  Pitches.FS1),
	G1  (49.0  , Nota.G , 9,  Pitches.G1 ),
	GS1 (52.0  , Nota.Gs, 10,  Pitches.GS1),
	A1  (55.0  , Nota.A , 11,  Pitches.A1 ),
	AS1 (58.0  , Nota.As, 12,  Pitches.AS1),
	B1  (62.0  , Nota.B , 13,  Pitches.B1 ),
	C2  (65.0  , Nota.C , 14,  Pitches.C2 ),
	CS2 (69.0  , Nota.Cs, 15,  Pitches.CS2),
	D2  (73.0  , Nota.D , 16,  Pitches.D2 ),
	DS2 (78.0  , Nota.Ds, 17,  Pitches.DS2),
	E2  (82.0  , Nota.E , 18,  Pitches.E2 ),
	F2  (87.0  , Nota.F , 19,  Pitches.F2 ),
	FS2 (93.0  , Nota.Fs, 20,  Pitches.FS2),
	G2  (98.0  , Nota.G , 21,  Pitches.G2 ),
	GS2 (104.0 , Nota.Gs, 22,  Pitches.GS2),
	A2  (110.0 , Nota.A , 23,  Pitches.A2 ),
	AS2 (117.0 , Nota.As, 24,  Pitches.AS2),
	B2  (123.0 , Nota.B , 25,  Pitches.B2 ),
	C3  (131.0 , Nota.C , 26,  Pitches.C3 ),
	CS3 (139.0 , Nota.Cs, 27,  Pitches.CS3),
	D3  (147.0 , Nota.D , 28,  Pitches.D3 ),
	DS3 (156.0 , Nota.Ds, 29,  Pitches.DS3),
	E3  (165.0 , Nota.E , 30,  Pitches.E3 ),
	F3  (175.0 , Nota.F , 31,  Pitches.F3 ),
	FS3 (185.0 , Nota.Fs, 32,  Pitches.FS3),
	G3  (196.0 , Nota.G , 33,  Pitches.G3 ),
	GS3 (208.0 , Nota.Gs, 34,  Pitches.GS3),
	A3  (220.0 , Nota.A , 35,  Pitches.A3 ),
	AS3 (233.0 , Nota.As, 36,  Pitches.AS3),
	B3  (247.0 , Nota.B , 37,  Pitches.B3 ),
	C4  (262.0 , Nota.C , 38,  Pitches.C4 ),
	CS4 (277.0 , Nota.Cs, 39,  Pitches.CS4),
	D4  (294.0 , Nota.D , 40,  Pitches.D4 ),
	DS4 (311.0 , Nota.Ds, 41,  Pitches.DS4),
	E4  (330.0 , Nota.E , 42,  Pitches.E4 ),
	F4  (349.0 , Nota.F , 43,  Pitches.F4 ),
	FS4 (370.0 , Nota.Fs, 44,  Pitches.FS4),
	G4  (392.0 , Nota.G , 45,  Pitches.G4 ),
	GS4 (415.0 , Nota.Gs, 46,  Pitches.GS4),
	A4  (440.0 , Nota.A , 47,  Pitches.A4 ),
	AS4 (466.0 , Nota.As, 48,  Pitches.AS4),
	B4  (494.0 , Nota.B , 49,  Pitches.B4 ),
	C5  (523.0 , Nota.C , 50,  Pitches.C5 ),
	CS5 (554.0 , Nota.Cs, 51,  Pitches.CS5),
	D5  (587.0 , Nota.D , 52,  Pitches.D5 ),
	DS5 (622.0 , Nota.Ds, 53,  Pitches.DS5),
	E5  (659.0 , Nota.E , 54,   Pitches.E5 ),
	F5  (698.0 , Nota.F , 55,  Pitches.F5 ),
	FS5 (740.0 , Nota.Fs, 56,  Pitches.FS5),
	G5  (784.0 , Nota.G , 57,  Pitches.G5 ),
	GS5 (831.0 , Nota.Gs, 58,  Pitches.GS5),
	A5  (880.0 , Nota.A , 59,  Pitches.A5 ),
	AS5 (932.0 , Nota.As, 60,  Pitches.AS5),
	B5  (988.0 , Nota.B , 61,  Pitches.B5 ),
	C6  (1047.0, Nota.C , 62,  Pitches.C6 ),
	CS6 (1109.0, Nota.Cs, 63,  Pitches.CS6),
	D6  (1175.0, Nota.D , 64,  Pitches.D6 ),
	DS6 (1245.0, Nota.Ds, 65,  Pitches.DS6),
	E6  (1319.0, Nota.E , 66,  Pitches.E6 ),
	F6  (1397.0, Nota.F , 67,  Pitches.F6 ),
	FS6 (1480.0, Nota.Fs, 68,  Pitches.FS6),
	G6  (1568.0, Nota.G , 69,  Pitches.G6 ),
	GS6 (1661.0, Nota.Gs, 70,  Pitches.GS6),
	A6  (1760.0, Nota.A , 71,  Pitches.A6 ),
	AS6 (1865.0, Nota.As, 72,  Pitches.AS6),
	B6  (1976.0, Nota.B , 73,  Pitches.B6 ),
	C7  (2093.0, Nota.C , 74,  Pitches.C7 ),
	CS7 (2217.0, Nota.Cs, 75,  Pitches.CS7),
	D7  (2349.0, Nota.D , 76,  Pitches.D7 ),
	DS7 (2489.0, Nota.Ds, 77,  Pitches.DS7),
	E7  (2637.0, Nota.E , 78,  Pitches.E7 ),
	F7  (2794.0, Nota.F , 79,  Pitches.F7 ),
	FS7 (2960.0, Nota.Fs, 80,  Pitches.FS7),
	G7  (3136.0, Nota.G , 81,  Pitches.G7 ),
	GS7 (3322.0, Nota.Gs, 82,  Pitches.GS7),
	A7  (3520.0, Nota.A , 83,  Pitches.A7 ),
	AS7 (3729.0, Nota.As, 84,  Pitches.AS7),
	B7  (3951.0, Nota.B , 85,  Pitches.B7 ),
	C8  (4186.0, Nota.C , 86,  Pitches.C8 ),
	CS8 (4435.0, Nota.Cs, 87,  Pitches.CS8),
	D8  (4699.0, Nota.D , 88,  Pitches.D8 ),
	DS8 (4978.0, Nota.Ds, 89,  Pitches.DS8);

	private Double frequencia;
	private Nota nota;
	private Integer pitch;
	private Integer posicao;
	private static Random random = Rand.get();

	private Som(Double frequencia, Nota nota, int posicao, int pitch) {
		this.frequencia = frequencia;
		this.nota = nota;
		this.pitch = pitch;
		this.posicao = posicao;
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
	public static List<Som> intervalo(Som inicio, Som fim) {
		return Arrays.asList(values()).stream().filter(s -> {
			return (s.getFrequencia() <=  fim.getFrequencia() && s.getFrequencia() >= inicio.getFrequencia());
		}).collect(Collectors.toList());
	}

	public static List<Som> getList() {
		return Arrays.asList(values());
	}
	
	public static Double getDistanciaTonal(Som som1, Som som2) {
		Double retorno = 0.0;
		
		Som somGrave = null;
		Som somAgudo = null;
		if(som1.posicao > som2.posicao) {
			somGrave = som2;
			somAgudo = som1;
		} else {
			somGrave = som1;
			somAgudo = som2;
		}
		
		for(Som s : values()) {
			if(s.posicao >= somAgudo.posicao) {
				break;
			}
			if(s.posicao >= somGrave.posicao) {
				retorno += 0.5;
			}
		}		
		return retorno;
	}
	
	public static Som getSomByDiferencaTonal(Som som, double diferencaEmTons) {
		Integer posicao = ((Double)(som.posicao + (diferencaEmTons*2.0))).intValue();
		for(Som s : values()){
			if  (s.posicao.equals(posicao))
				return s;
		}
		throw new RuntimeException("não foi possivel encontrar som valor ["+posicao+"]");
	}
	
	
	public Integer getPitch() {
		return pitch;
	}
	
	private static Map<Som, Double> mapProbabilidade(List<Som> notas, List<Som> escalaCromatica, Som som, Escala escala, ListaNota acorde) {
		Map<Som, Double> probabilidadeEscala = new TreeMap<Som, Double>();
		Double somatoria = 0.0;
		double sValue = 1.00;
		double sValueEscala = 1.03;
		
		//soma probabilidade com base na distribuicao normal em relacao a ultima nota tocada
		for(Som s : escalaCromatica) {
			double valor = DistribuicaoNormal.getY(s.posicao.doubleValue(), som.posicao.doubleValue(), sValue) /2.5;
			somatoria += valor;
			probabilidadeEscala.put(s, valor);
		}
		
		//soma probabilidade nas notas pertencentes a escala
		for(Som s : notas) {
			double valor = DistribuicaoNormal.getY(s.posicao.doubleValue(), som.posicao.doubleValue(), sValueEscala);
			somatoria += valor;
			probabilidadeEscala.put(s, probabilidadeEscala.get(s) + valor);
		}
		
		
		//soma valores nas notas pertencentes a triade
		double valorSomadoPertencentesAoAcorde = (somatoria / (notas.size())) * 1.2;
		for(Som s : notas) {
			if(acorde.getAcorde().getTriade().pertenceAoAcorde(s)) {
				double valor = ((valorSomadoPertencentesAoAcorde + (probabilidadeEscala.get(s)*2)) / 3) / 2;
				somatoria += valor;
				probabilidadeEscala.put(s, probabilidadeEscala.get(s) + valor);
			}
		}
		
		
		//remove probabilidade de nota tocada
		double valorAcordeAnterior = probabilidadeEscala.get(som);
		double novoValorAcordeAnterior = 0.0;
		if(!escala.pertence(som)) {
			novoValorAcordeAnterior = valorAcordeAnterior / 6;
		} else if (!acorde.pertenceAoAcorde(som)) {
			novoValorAcordeAnterior = valorAcordeAnterior / 4;
		} else {
			novoValorAcordeAnterior = valorAcordeAnterior / 2;
		}
		probabilidadeEscala.put(som, novoValorAcordeAnterior);
		somatoria -= valorAcordeAnterior - novoValorAcordeAnterior;
		
		
		for(Som s : escalaCromatica) {
			probabilidadeEscala.put(s, probabilidadeEscala.get(s) / somatoria);
		}
		return probabilidadeEscala;
	}
	
	public static Map<Som, Double> mapProbabilidade(List<Som> notas, Som som, Escala escala) {
		List<Som> escalaCromatica = Som.getList().stream().filter(s ->  s.posicao >= notas.get(0).posicao && s.posicao <= notas.get(notas.size() -1).posicao).collect(Collectors.toList());
		return mapProbabilidade(notas, escalaCromatica, som, escala, null);
	}
	
	public static List<Probabilidade<Som>> gerarProbabilidades(List<Som> notas, List<Som> escalaCromatica, Som som, Escala escala, ListaNota acordeCompasso) {
		Map<Som, Double> mapProbabilidade = mapProbabilidade(notas, escalaCromatica, som, escala, acordeCompasso);
		List<Probabilidade<Som>> probabilidades = new ArrayList<Probabilidade<Som>>();
		mapProbabilidade.forEach((k, v) -> probabilidades.add(new Probabilidade<Som>(v, k)));
		return probabilidades;
	}
}
