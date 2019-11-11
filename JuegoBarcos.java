package Proyecto_Teorico;

import java.util.Scanner;

public class JuegoBarcos {

	final static Scanner TECLADO = new Scanner(System.in);
	public static int numFilas;
	public static int numColumnas;
	public static int [] [] tableroJugador1G;
	public static int [] [] tableroJugador2G;
	//public static int [] [] tableroJugador2;
	
	public static void main(String[] args) {

		int posicionX = 0;
		int posicionY = 0;
		
		
		System.out.println("Introduzca el numero de filas de su tablero: ");
		numFilas = TECLADO.nextInt();
		
		while (numFilas < 0) { 		
			System.out.println("El numero de filas debe ser mayor que 0");
			System.out.println("Introduzca un nuevo valor válido: ");
			numFilas = TECLADO.nextInt();
			
		}
		
		System.out.println("Introduzca el numero de columnas de su tablero: ");
		numColumnas = TECLADO.nextInt();
		
		while (numColumnas < 0) { 		
			System.out.println("El numero de columnas debe ser mayor que 0");
			System.out.println("Introduzca un nuevo valor válido: ");
			numColumnas = TECLADO.nextInt();
			
		}
		
		int [] [] tableroJugador1 = new int [numFilas] [numColumnas];
		tableroJugador1G = tableroJugador1;
		int [] [] tableroJugador2 = new int [numFilas] [numColumnas];
		tableroJugador2G = tableroJugador2;
		
		System.out.println("Tablero creado (" + numFilas + "x" + numColumnas + ")\n");	
		
		tableroJugador1();
		
		System.out.println();
		
		System.out.println("BARCO 1");
		System.out.print("Jugador 1, posicion X del barco 1 (tamaño de barco = 1): ");
		posicionX = TECLADO.nextInt();	
		while (posicionX < 0 || posicionX > numFilas) {	
			System.out.println("Introduzca un valor válido: ");
			posicionX = TECLADO.nextInt();
		}
		
		System.out.print("Jugador 1, posicion Y del barco 1 (tamaño de barco = 1): ");
		posicionY = TECLADO.nextInt();
		while (posicionY < 0 || posicionY > numFilas) {
			System.out.println("Introduzca un valor válido: ");
			posicionY = TECLADO.nextInt();		
		}
		
		tableroJugador1[posicionX-1][posicionY-1] = 1;
		
		System.out.println();
		System.out.println("Tablero jugador 1: \n");
		tableroJugador1();
		
		System.out.println();
		
		System.out.println("BARCO 1");
		System.out.print("Jugador 2, posicion X del barco 1 (tamaño de barco = 1): ");
		posicionX = TECLADO.nextInt();
		while (posicionX < 0 || posicionX > numFilas) {	
			System.out.println("Introduzca un valor válido: ");
			posicionX = TECLADO.nextInt();
		}	
		
		System.out.print("Jugador 2, posicion Y del barco 1 (tamaño de barco = 1): ");
		posicionY = TECLADO.nextInt();
		while (posicionY < 0 || posicionY > numFilas) {
			System.out.println("Introduzca un valor válido: ");
			posicionY = TECLADO.nextInt();		
		}
		
		
		tableroJugador2[posicionX-1][posicionY-1] = 1;
		
		System.out.println();
		System.out.println("Tablero jugador 1: \n");
		tableroJugador2();
		
		/*
		System.out.println("Jugador 1, posicion X del barco 2 (tamaño = 2)");
		posicionX = TECLADO.nextInt();
		
		System.out.println("Jugador 1, posicion Y del barco 2 (tamaño = 2)");
		posicionY = TECLADO.nextInt();
		*/
			
	}
		
	public static void tableroJugador1() {

		int k = 1;
		
		for (int i = 0; i <= numColumnas; i++) {
			if (i < 10 && i != 0) System.out.print(i + "   ");
			else if (i==0) System.out.print("      ");
			else System.out.print(i + "  ");					
		}
		
		System.out.println();
		System.out.println();
	
		
		for (int i = 0; i < tableroJugador1G.length; i++) {
			
			if (i < 9) System.out.print(k + "     ");			
			else System.out.print(k + "    ");
			k++;
			
			for (int j = 0; j < tableroJugador1G[i].length; j++) {
				System.out.print(+tableroJugador1G[i][j] + "   ");
			}
			System.out.println();
		}
		
		
	}
	
	
	public static void tableroJugador2() {

		int k = 1;
		
		for (int i = 0; i <= numColumnas; i++) {
			if (i < 10 && i != 0) System.out.print(i + "   ");
			else if (i==0) System.out.print(i + "     ");
			else System.out.print(i + "  ");					
		}
		
		System.out.println();
		System.out.println();
	
		
		for (int i = 0; i < tableroJugador2G.length; i++) {
			
			if (i < 9) System.out.print(k + "     ");			
			else System.out.print(k + "    ");
			k++;
			
			for (int j = 0; j < tableroJugador2G[i].length; j++) {
				System.out.print(+tableroJugador2G[i][j] + "   ");
			}
			System.out.println();
		}
		
		
	}
	
	
	public static void jugar() {
		
		
	}
	

}
