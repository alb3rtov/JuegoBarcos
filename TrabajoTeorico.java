package Proyecto_Teorico;

import java.util.Scanner;

public class TrabajoTeorico {

	final static Scanner TECLADO = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		
		bienvenidaPrograma();
		
		int numFilas = numFilas();
		int numColumnas = numColumnas();
		boolean esJugador1;
		
		boolean [][] tableroJugador1 = new boolean [numFilas] [numColumnas];
		boolean [][] tableroJugador2 = new boolean [numFilas] [numColumnas];
		
		inicializarTableros(tableroJugador1, tableroJugador2);
		
		
		esJugador1 = true;
		posicionBarco(tableroJugador1, esJugador1);		
		tableroJugador(tableroJugador1, esJugador1);

		esJugador1 = false;
		posicionBarco(tableroJugador2, esJugador1);
		tableroJugador(tableroJugador2, esJugador1);
		
		comienzaJuego(tableroJugador1, tableroJugador2, esJugador1);

	}
	
	private static void bienvenidaPrograma() {
		System.out.println("***************************************");
		System.out.println("** Bienvenido al Juego de los Barcos **");
		System.out.println("***************************************");
		System.out.println("Programa realizado por: ");
		System.out.println(" - Alberto Vázquez Martínez");
		System.out.println(" - Alvaro Ramos Cobacho");
		System.out.println(" - Angel Villafranca Iniesta");
		System.out.println(" - Carlos Herencia García");
		System.out.println();
		System.out.println("Las X representan los barcos");
		System.out.println("Las O representan agua");
		System.out.println("Comienza el juego....");
		System.out.println();
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
			System.out.println("Indique el número de filas del tablero (1-15): ");
			numFilas = TECLADO.nextInt();
		} while (numFilas <= 0 || numFilas > 15);
		
		return numFilas;	
	}
	
	
	
	private static int numColumnas() {
		int numColumnas;	
		do {
			System.out.println("Indique el número de columnas del tablero (1-15): ");
			numColumnas = TECLADO.nextInt();
		} while (numColumnas <= 0 || numColumnas > 15);
		
		return numColumnas;		
	}
	
	
	
	private static void tableroJugador(boolean [][] tableroJugador, boolean esJugador1) {
		if (esJugador1) 
			System.out.println(" --------------- TABLERO JUGADOR 1 --------------- ");
		
		else 
			System.out.println(" --------------- TABLERO JUGADOR 2 --------------- ");
		
		System.out.println();
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador[i].length; j++) {
				if (tableroJugador[i][j]) System.out.print("X ");
				else System.out.print("O ");
			}	
			System.out.println();
		}
		System.out.println();
		
		ocultarTablero();
	}
	
	
	
	private static void posicionBarco(boolean [][] tableroJugador, boolean esJugador1) {
		int numFila, numColumna;
		int filaBarco1 = 0;
		int columnaBarco1 = 0;
		String orientacionBarco;
		
		System.out.println();
		
		if (esJugador1) 
			System.out.println(" --------------- TURNO JUGADOR 1 --------------- ");
		
		else 
			System.out.println(" --------------- TURNO JUGADOR 2 --------------- ");
		
		System.out.println("Introduzca la posicion de barco numero 1 (tamaño 1x1)");
		System.out.println("Indique el numero de fila (1-" + tableroJugador.length + "): ");
		numFila = TECLADO.nextInt();
		
		while (numFila <= 0 || numFila > tableroJugador.length) {
			System.out.println("Introduzca un numero de la fila correcto (1-" + tableroJugador.length + ")");
			numFila = TECLADO.nextInt();
		}
		
		System.out.println("Indique el numero de columna (1-" + tableroJugador[0].length + "): ");
		numColumna = TECLADO.nextInt();
		
		while (numFila <= 0 || numColumna > tableroJugador[0].length) {
			System.out.println("Introduzca un numero de la columna correcto (1-" + tableroJugador[0].length + ")");
			numColumna = TECLADO.nextInt();
		}
		
		tableroJugador[numFila-1][numColumna-1] = true;
		System.out.println();

		System.out.println("Introduzca la posicion de barco numero 2 (tamaño 1x2)");
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
		boolean avisoError = false;
		String opcion;
		
		do {
			if (avisoError) {
				System.out.println("La posición indicada no es válida");
				System.out.println("Recuerda que barco 2 no puede estar en la misma posición que barco 1");
				System.out.println("Barco 2 tampoco puede estar contiguo a barco 1");
				System.out.println();
			}
			
			avisoError = true;
			
			System.out.println("Indique la primera fila del barco 2 (1-" + tableroJugador.length + "): ");
			fila1 = TECLADO.nextInt();
			
			while (fila1 <= 0 || fila1 > tableroJugador.length) {
				System.out.println("Introduzca un valor correcto (1-" + tableroJugador.length + ")");
				System.out.println("Indique la primera fila del barco 2: ");
				fila1 = TECLADO.nextInt();
			}
			
			int filaMenosUno = fila1-1;
			int filaMasUno = fila1+1;
	
			if (fila1 == 1) {
				System.out.println("Indique la segunda fila del barco 2 (Solo puede ser " + filaMasUno + "): ");
				opcion = "Indique la segunda fila del barco 2 (Solo puede ser " + filaMasUno + "): ";
			}
			
			else if (fila1 == tableroJugador.length) {
				System.out.println("Indique la segunda fila del barco 2 (Solo puede ser " + filaMenosUno + "): ");
				opcion = "Indique la segunda fila del barco 2 (Solo puede ser " + filaMenosUno + "): ";
			}
			
			else {
				System.out.println("Indique la segunda fila del barco 2 (" + filaMenosUno + "-" + filaMasUno + "): ");
				opcion = "Indique la segunda fila del barco 2 (" + filaMenosUno + "-" + filaMasUno + "): ";
			}
			
			fila2 = TECLADO.nextInt();
			
			
			while (fila2 < filaMenosUno || fila2 > filaMasUno || fila2 == fila1) {
				System.out.println("Introduzca un valor correcto");
				System.out.println(opcion);
				fila2 = TECLADO.nextInt();
			}
			
			System.out.println("Indique la columna de barco (1-" + tableroJugador[0].length + ")");
			columna = TECLADO.nextInt();
			
			
			while (columna <= 0 || columna > tableroJugador[0].length) {
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
		boolean avisoError = false;
		String opcion;
		
		do {
			
			if (avisoError) {
				System.out.println("La posición indicada no es válida");
				System.out.println("Recuerda que barco 2 no puede estar en la misma posición que barco 1");
				System.out.println("Barco 2 tampoco puede estar contiguo a barco 1");
				System.out.println();
			}
			
			avisoError = true;
		
			System.out.println("Indique la fila del barco 2 (1-" + tableroJugador.length + "): ");
			fila = TECLADO.nextInt();
			
			while (fila <= 0 || fila > tableroJugador.length) {
				System.out.println("Introduzca un valor correcto (1-" + tableroJugador.length + ")");
				System.out.println("Indique la fila del barco 2: ");
				fila = TECLADO.nextInt();
			}
					
			System.out.println("Indique la primera columna del barco 2 (1-" + tableroJugador[0].length + "): ");
			columna1 = TECLADO.nextInt();
			
			while (columna1 <= 0 || columna1 > tableroJugador[0].length) {
				
				System.out.println("Introduzca un valor correcto ((1-" + tableroJugador[0].length + "): ");
				System.out.println("Indique la primera columna del barco 2: ");
				columna1 = TECLADO.nextInt();
			}
			
			int columnaMenosUno = columna1-1;
			int columnaMasUno = columna1+1;
			
			if (columna1 == 1) {
				System.out.println("Indique la segunda columna del barco 2 (Solo puede ser " + columnaMasUno + "): ");
				opcion = "Indique la segunda columna del barco 2 (Solo puede ser " + columnaMasUno + "): ";
			}
			
			else if (columna1 == tableroJugador[0].length) {
				System.out.println("Indique la segunda columna del barco 2 (Solo puede ser " + columnaMenosUno + "): ");
				opcion = "Indique la segunda columna del barco 2 (Solo puede ser " + columnaMenosUno + "): ";
			}
			
			else {
				System.out.println("Indique la segunda columna del barco 2 (" + columnaMenosUno + "-" + columnaMasUno + "): ");
				opcion = "Indique la segunda columna del barco 2 (" + columnaMenosUno + "-" + columnaMasUno + "): ";
			}
			
			columna2 = TECLADO.nextInt();
			
			while (columna2 < columnaMenosUno || columna2 > columnaMasUno || columna2 == columna1) {
				System.out.println("Introduzca un valor correcto");
				System.out.println(opcion);
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
	
	
	private static void comienzaJuego(boolean [][] tableroJugador1, boolean[][] tableroJugador2, boolean esJugador1) {
		
		boolean turnoJugador = true;
		boolean partidaEnJuego = true;
		boolean [][] tableroAuxiliar;
		int fila, columna;
		int contadorAtaquesJ1 = 0;
		int contadorAtaquesJ2 = 0;
		boolean ganador = false;
		
		System.out.println("Que comienze el juego...\n");
		
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
			System.out.println("Numero de la fila a atacar (1-" + tableroAuxiliar.length + "): ");
			fila = TECLADO.nextInt();
			
			while (fila <= 0 || fila > tableroAuxiliar.length) {
				System.out.println("Introduzca una fila correcta (1-" + tableroAuxiliar.length + "): ");
				fila = TECLADO.nextInt();
			}
			
			System.out.println("Numero de la columna a atacar (1-" + tableroAuxiliar[0].length + "): ");
			columna = TECLADO.nextInt();		
			while (columna <= 0 || columna > tableroAuxiliar[0].length) {
				System.out.println("Introduzca una columna correcta (1-" + tableroAuxiliar[0].length + "): ");
				columna = TECLADO.nextInt();
			}

			comprobarAtaque(tableroAuxiliar, fila, columna);
			
			//if (turnoJugador) tableroJugador(tableroJugador1, esJugador1);
			//else tableroJugador(tableroJugador2, esJugador1);
	
			partidaEnJuego = comprobarTablero(tableroAuxiliar);
			
			if (!partidaEnJuego) {
				if (turnoJugador) 
					ganador = true;
				else 
					ganador = false;
			}	
		}
		
		finDeJuego(contadorAtaquesJ1, contadorAtaquesJ2, ganador);
	}
	
	
	private static void comprobarAtaque(boolean [][] tableroAuxiliar, int fila, int columna) {
		
		if (tableroAuxiliar[fila-1][columna-1]) {
			
			if (fila-1 == 0 && columna-1 == 0) {
				System.out.println("Heyy");
				if (tableroAuxiliar[fila-1][columna] ||
					tableroAuxiliar[fila][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
					
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
			}
			
			else if (fila-1 == 0 && columna-1 == tableroAuxiliar[0].length-1) {
				
				if (tableroAuxiliar[fila-1][columna-2] ||
					tableroAuxiliar[fila][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
						
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
			}
			
			
			else if (fila-1 == tableroAuxiliar.length-1 && columna-1 == 0) {
				
				if (tableroAuxiliar[fila-2][columna-1] ||
					tableroAuxiliar[fila-1][columna]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
						
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
			}
			
			else if (fila-1 == tableroAuxiliar.length-1 && columna-1 == tableroAuxiliar[0].length-1) {
				
				if (tableroAuxiliar[fila-1][columna-2] ||
						tableroAuxiliar[fila-2][columna-1]) 
					{
						System.out.println("Tocado");
						tableroAuxiliar[fila-1][columna-1] = false;
					}		
					else {
						System.out.println("Hundido");
						tableroAuxiliar[fila-1][columna-1] = false;
					}
			}
			
			else if (fila-1 == 0) {
				System.out.println("La columna no es 0");
				if (tableroAuxiliar[fila-1][columna-2] ||
						tableroAuxiliar[fila-1][columna] ||
						tableroAuxiliar[fila][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
					
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}	
			}
			
			
			else if (fila-1 == tableroAuxiliar.length-1) {
				
				if (tableroAuxiliar[fila-1][columna-2] ||
					tableroAuxiliar[fila-1][columna] ||
					tableroAuxiliar[fila-2][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
					
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}	
			}
			
			
			else if (columna-1 == 0) {
				
				if (tableroAuxiliar[fila-1][columna] ||
					tableroAuxiliar[fila-2][columna-1] ||
					tableroAuxiliar[fila][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
					
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}	
			}
				
			
			else if (columna-1 == tableroAuxiliar[0].length-1) {
				
				if (tableroAuxiliar[fila-1][columna-2] ||
					tableroAuxiliar[fila-2][columna-1] ||
					tableroAuxiliar[fila][columna-1]) 
				{
					System.out.println("Tocado");
					tableroAuxiliar[fila-1][columna-1] = false;
				}
					
				else {
					System.out.println("Hundido");
					tableroAuxiliar[fila-1][columna-1] = false;
				}	
			}
			
			else {
				// ESTO ES LO QUE FALTA POR ARREGLAR
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
		}
		
		else System.out.println("Agua");
		
		}
	
	
	private static boolean comprobarTablero(boolean [][] tableroAuxiliar) {
		boolean partidaEnJuego = false;
		
		for (int i = 0; i < tableroAuxiliar.length; i++) {
			for (int j = 0; j < tableroAuxiliar[i].length; j++) {
				if (tableroAuxiliar[i][j]) partidaEnJuego = true;				
			}
		}
		return partidaEnJuego;
	}
	
	
	private static void finDeJuego(int contadorAtaquesJ1, int contadorAtaquesJ2, boolean ganador) {
		System.out.println();
		if (!ganador) System.out.println("Jugador 1 gana la partida");	
		else System.out.println("Jugador 2 gana la partida");
		System.out.println("Numero de ataques jugador 1: " + contadorAtaquesJ1);
		System.out.println("Numero de ataques jugador 2: " + contadorAtaquesJ2);	
	}
	
	private static void ocultarTablero() {
		
		System.out.println("Presiona ENTER para continuar...");
		TECLADO.nextLine();
		TECLADO.nextLine();
		
		for (int i = 0; i < 25; i++) {
			System.out.println("\n");
		}
		
	}
	
}

// FALTA ARREGLAR LOS LIMITES DEL ARRAY CUANDO VAYA A INTRODUCIR EL BARCO 2
// MEJORAR CUANDO MUESTRE EN PANTALLA EL TABLERO, MOSTRAR TABLERO ADECUADO...