package Proyecto_Teorico;

import java.util.Scanner;

public class TrabajoTeorico {

	final static Scanner TECLADO = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		
		int numFilas = numFilas();
		int numColumnas = numColumnas();
		boolean esJugador1;
		
		
		boolean [][] tableroJugador1 = new boolean [numFilas] [numColumnas];
		boolean [][] tableroJugador2 = new boolean [numFilas] [numColumnas];
		
		inicializarTableros(tableroJugador1, tableroJugador2);
		
		
		esJugador1 = true;
		posicionBarco(tableroJugador1, esJugador1);
		tableroJugador(tableroJugador1);

		esJugador1 = false;
		posicionBarco(tableroJugador2, esJugador1);
		tableroJugador(tableroJugador2);
		
		
		comienzaJuego(tableroJugador1, tableroJugador2);

	}
	
	
	private static void inicializarTableros(boolean [][] tableroJugador1, boolean [][] tableroJugador2) {		
		for (int i = 0; i < tableroJugador1.length; i++) {
			for (int j = 0; j < tableroJugador1[0].length; j++) {
				tableroJugador1[i][j] = false;
				tableroJugador2[i][j] = false;
			}
		}
	}
	
	
	private static int numFilas() {
		int numFilas;
		do {
			System.out.println("Indique el número de filas: ");
			numFilas = TECLADO.nextInt();
		} while (numFilas < 0);
		
		return numFilas;	
	}
	
	
	
	private static int numColumnas() {
		int numColumnas;	
		do {
			System.out.println("Indique el número de columnas: ");
			numColumnas = TECLADO.nextInt();
		} while (numColumnas < 0);
		
		return numColumnas;		
	}
	
	
	
	private static void tableroJugador(boolean [][] tableroJugador) {
		
		System.out.println();
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador[i].length; j++) {
				if (tableroJugador[i][j]) System.out.print("X ");
				else System.out.print("O ");
			}	
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	private static void posicionBarco(boolean [][] tableroJugador, boolean esJugador1) {
		int numFila, numColumna;
		int filaBarco1 = 0;
		int columnaBarco1 = 0;
		String orientacionBarco;
		
		if (esJugador1) 
			System.out.println(" --------------- TURNO JUGADOR 1 --------------- ");
		
		else 
			System.out.println(" --------------- TURNO JUGADOR 2 --------------- ");
		
		System.out.println("Introduzca la posicion de barco numero 1 (tamaño 1x1)");
		System.out.println("Indique el numero de fila: ");
		numFila = TECLADO.nextInt();
		
		while (numFila > tableroJugador.length && numFila == 0) {
			System.out.println("Introduzca un numero de la fila correcto (1 - " + tableroJugador.length + ")");
			numFila = TECLADO.nextInt();
		}
		
		System.out.println("Indique el numero de columna: ");
		numColumna = TECLADO.nextInt();
		
		while (numColumna > tableroJugador[0].length && numFila == 0) {
			System.out.println("Introduzca un numero de la columna correcto (1 - " + tableroJugador[0].length + ")");
			numColumna = TECLADO.nextInt();
		}
		
		tableroJugador[numFila-1][numColumna-1] = true;
		System.out.println();

		
		System.out.println("Desea posicionar su barco de manera vertical u horizontal (v/h): ");
		TECLADO.nextLine();
		orientacionBarco = TECLADO.nextLine();
		
		while (!orientacionBarco.equalsIgnoreCase("v") && !orientacionBarco.equalsIgnoreCase("h")) {	
			System.out.println("Introduzca una opción correcta (v/h)");
			System.out.println("Desea posicionar su barco de manera vertical u horizontal (v/h): ");
			orientacionBarco = TECLADO.nextLine();
		}
		
		
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador[i].length; j++) {
				
				if (tableroJugador[i][j]) {
					filaBarco1 = i+1;
					columnaBarco1 = j+1;
				} 
				
			}
		}
		
		
		if (orientacionBarco.equalsIgnoreCase("v")) {
			posicionBarcoVertical(tableroJugador, filaBarco1, columnaBarco1);
		}
		
		
		else if (orientacionBarco.equalsIgnoreCase("h")) {
			posicionBarcoHorizontal(tableroJugador, filaBarco1, columnaBarco1);
		}	
	}
	
	// Falta comprobar dos cosas:
	// - Comprobar que el que si esta en los limites del tablero solo deje poner una posicion
	private static void posicionBarcoVertical(boolean [][] tableroJugador, int filaBarco1, int columnaBarco1) {
		
		int fila1, fila2, columna;
		
		do {
		
		System.out.println("Indique la primera fila del barco 2 (1-" + tableroJugador.length + "): ");
		fila1 = TECLADO.nextInt();
		
		while (fila1 <= 0 && fila1 > tableroJugador.length) {
			System.out.println("Introduzca un valor correcto (1-" + tableroJugador.length + ")");
			System.out.println("Indique la primera fila del barco 2: ");
			fila1 = TECLADO.nextInt();
		}
		
		int filaMenosUno = fila1-1;
		int filaMasUno = fila1+1;

		System.out.println("Indique la segunda fila del barco 2 (" + filaMenosUno + "-" + filaMasUno + "): ");
		fila2 = TECLADO.nextInt();
		
		
		while (fila2 < filaMenosUno || fila2 > filaMasUno || fila2 == fila1) {
			System.out.println("Introduzca un valor correcto (" + filaMenosUno + "-" + filaMasUno + "): ");
			System.out.println("Indique la segunda fila del barco 2: ");
			fila2 = TECLADO.nextInt();
		}
		
		System.out.println("Indique la columna de barco (1-" + tableroJugador[0].length + ")");
		columna = TECLADO.nextInt();
		
		
		while (columna <= 0 && columna > tableroJugador[0].length) {
			System.out.println("Introduzca un valor correcto (1-" + tableroJugador[0].length + ")");
			System.out.println("Indique la columna de barco 2: ");
			columna = TECLADO.nextInt();
		}
		
		
		}
		
		while(fila1 == filaBarco1  && columna == columnaBarco1 || 
				fila1 == filaBarco1 && columna == columnaBarco1-1 ||
				fila1 == filaBarco1 && columna == columnaBarco1+1 ||
				fila1 == filaBarco1-1 && columna == columnaBarco1 ||
				fila1 == filaBarco1+1 && columna == columnaBarco1 ||
				fila2 == filaBarco1 && columna == columnaBarco1 ||
				fila2 == filaBarco1 && columna == columnaBarco1-1 ||
				fila2 == filaBarco1 && columna == columnaBarco1+1 ||
				fila2 == filaBarco1-1 && columna == columnaBarco1 ||
				fila2 == filaBarco1+1 && columna == columnaBarco1
				);
		
		tableroJugador[fila1-1][columna-1] = true;
		
		tableroJugador[fila2-1][columna-1] = true;
		
		
		
	}
	
	
	
	private static void posicionBarcoHorizontal(boolean [][] tableroJugador, int filaBarco1, int columnaBarco1) {
		
		int fila, columna1, columna2;
		
		
		do {
		
		System.out.println("Indique la fila del barco 2 (1-" + tableroJugador.length + "): ");
		fila = TECLADO.nextInt();
		
		while (fila <= 0 && fila > tableroJugador.length) {
			System.out.println("Introduzca un valor correcto (1-" + tableroJugador.length + ")");
			System.out.println("Indique la fila del barco 2: ");
			fila = TECLADO.nextInt();
		}
				
		System.out.println("Indique la primera columna del barco 2 (1-" + tableroJugador[0].length + "): ");
		columna1 = TECLADO.nextInt();
		
		while (columna1 <= 0 && columna1 > tableroJugador[0].length) {
			
			System.out.println("Introduzca un valor correcto ((1-" + tableroJugador[0].length + "): ");
			System.out.println("Indique la primera columna del barco 2: ");
			columna1 = TECLADO.nextInt();
		}
		
		int columnaMenosUno = columna1-1;
		int columnaMasUno = columna1+1;
		
		
		System.out.println("Indique la segunda columna del barco 2 (" + columnaMenosUno + "-" + columnaMasUno + "): ");
		columna2 = TECLADO.nextInt();
		
		while (columna2 < columnaMenosUno || columna2 > columnaMasUno || columna2 == columna1) {
			System.out.println("Introduzca un valor correcto (" + columnaMenosUno + "-" + columnaMasUno + "): ");
			System.out.println("Indique la segunda fila del barco 2: ");
			columna2 = TECLADO.nextInt();
		}
		
		}
		
		while (columna1 == columnaBarco1 && fila == filaBarco1 ||
				columna1 == columnaBarco1-1 && fila == filaBarco1 ||
				columna1 == columnaBarco1+1 && fila == filaBarco1 ||
				columna1 == columnaBarco1 && fila == filaBarco1-1 ||
				columna1 == columnaBarco1 && fila == filaBarco1+1 ||
				columna2 == columnaBarco1 && fila == filaBarco1 || 
				columna2 == columnaBarco1-1 && fila == filaBarco1 ||
				columna2 == columnaBarco1+1 && fila == filaBarco1 ||
				columna2 == columnaBarco1 && fila == filaBarco1-1 ||
				columna2 == columnaBarco1 && fila == filaBarco1+1
				); 
		
		tableroJugador[fila-1][columna1-1] = true;
		
		tableroJugador[fila-1][columna2-1] = true;
		
	}
	
	
	private static void comienzaJuego(boolean [][] tableroJugador1, boolean[][] tableroJugador2) {
		
		boolean turnoJugador = true;
		boolean partidaEnJuego = true;
		boolean [][] tableroAuxiliar;
		int fila, columna;
		int contadorAtaquesJ1 = 0;
		int contadorAtaquesJ2 = 0;
		boolean ganador = false;
		
		while (partidaEnJuego) {
			
			if (turnoJugador) {
				System.out.println(" --------------- TURNO JUGADOR 1 --------------- "); 
				tableroAuxiliar = tableroJugador2;
				contadorAtaquesJ1++;
				turnoJugador = false;
			}
			else {
				System.out.println(" --------------- TURNO JUGADOR 2 --------------- "); 
				tableroAuxiliar = tableroJugador1;	
				contadorAtaquesJ2++;
				turnoJugador = true;
			}
			
			System.out.println("Introduzca las coordenadas a atacar");
			System.out.println("Numero de la fila a atacar: ");
			fila = TECLADO.nextInt();
			System.out.println("Numero de la columna a atacar: ");
			columna = TECLADO.nextInt();		
			comprobarAtaque(tableroAuxiliar, fila, columna);
			
			if (turnoJugador) {
				System.out.println("Tablero Jugador 1");
				tableroJugador(tableroJugador1);
			}
			
			else {
				System.out.println("Tablero Jugador 2");
				tableroJugador(tableroJugador2);
			}
			
			
			partidaEnJuego = comprobarTablero(tableroAuxiliar);
			
			if (!partidaEnJuego) {
				
				if (turnoJugador) {
					
					ganador = true;
				}
				
				else {
					
					ganador = false;
				}
				
			}
			
		}
		
		
		finDeJuego(contadorAtaquesJ1, contadorAtaquesJ2, ganador);
	}
	
	
	private static void comprobarAtaque(boolean [][] tableroAuxiliar, int fila, int columna) {
		
		if (tableroAuxiliar[fila-1][columna-1]) {
			
			if (tableroAuxiliar[fila-1][columna-2] ||
				tableroAuxiliar[fila-1][columna] ||
				tableroAuxiliar[fila-2][columna-1] ||
				tableroAuxiliar[fila][columna-1]      	
				) {
				System.out.println("Tocado");
				tableroAuxiliar[fila-1][columna-1] = false;
			}
			
			else {
				System.out.println("Hundido");
				tableroAuxiliar[fila-1][columna-1] = false;
			}	
		}
		else {
			System.out.println("Agua");	
		}
	}
	
	
	private static boolean comprobarTablero(boolean [][] tableroAuxiliar) {
		boolean partidaEnJuego = false;
		
		for (int i = 0; i < tableroAuxiliar.length; i++) {
			for (int j = 0; j < tableroAuxiliar[i].length; j++) {
				if (tableroAuxiliar[i][j]) {
					partidaEnJuego = true;	
				}				
			}
		}

		return partidaEnJuego;
	}
	
	
	private static void finDeJuego(int contadorAtaquesJ1, int contadorAtaquesJ2, boolean ganador) {
		
		if (ganador) {
			System.out.println("Jugador 1 gana la partida");	
		}
		else {
			System.out.println("Jugador 2 gana la partida");
			
		}
				
		
		System.out.println("Numero de ataques jugador 1: " + contadorAtaquesJ1);
		System.out.println("Numero de ataques jugador 2: " + contadorAtaquesJ2);	
	}
	
	
}
