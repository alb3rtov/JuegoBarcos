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
		
		System.out.println("Indiquee el numero de columna: ");
		numColumna = TECLADO.nextInt();
		
		while (numColumna > tableroJugador[0].length && numFila == 0) {
			System.out.println("Introduzca un numero de la columna correcto (1 - " + tableroJugador[0].length + ")");
			numColumna = TECLADO.nextInt();
		}
		
		tableroJugador[numFila-1][numColumna-1] = true;
		System.out.println();
		
		
		//Falta el barco 2
		
		System.out.println("Desea posicionar su barco de manera vertical u horizontal (v/h): ");
		TECLADO.nextLine();
		orientacionBarco = TECLADO.nextLine();
		
		while (!orientacionBarco.equalsIgnoreCase("v") && !orientacionBarco.equalsIgnoreCase("h")) {	
			System.out.println("Introduzca una opción correcta (v/h)");
			System.out.println("Desea posicionar su barco de manera vertical u horizontal (v/h): ");
			orientacionBarco = TECLADO.nextLine();
		}
		
		
		if (orientacionBarco.equalsIgnoreCase("v")) {
			posicionBarcoVertical(tableroJugador);
		}
		
		
		else if (orientacionBarco.equalsIgnoreCase("h")) {
			posicionBarcoHorizontal(tableroJugador);
		}		
	}
	
	
	// Falta comprobar dos cosas:
	// - Comprobar que el que si esta en los limites del tablero solo deje poner una posicion
	// - Comprobar que no esta tocando el otro barco 
	private static void posicionBarcoVertical(boolean [][] tableroJugador) {
		
		int fila1, fila2, columna;
		
		
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
		
		tableroJugador[fila1-1][columna-1] = true;
		
		tableroJugador[fila2-1][columna-1] = true;
		
	}
	
	
	
	private static void posicionBarcoHorizontal(boolean [][] tableroJugador) {
		
		int fila, columna1, columna2;
		
		
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
		

		
		tableroJugador[fila-1][columna1-1] = true;
		
		tableroJugador[fila-1][columna2-1] = true;
		
	}
	
	
	
	
	
	private static void jugar() {
		
		boolean turnoJugador1, turnoJugador2;
		

		
	}
	
}
