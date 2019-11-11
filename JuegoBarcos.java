package Proyecto_Teorico;

import java.util.Scanner;

public class JuegoBarcos {

	final static Scanner TECLADO = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numFilas;
		int numColumnas;
		int k = 1;
		
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
		
		
		
		int posicionX = 0;
		int posicionY = 0;
		
		int [] [] tableroJugador1 = new int [numFilas] [numColumnas] ;
		int [] [] tableroJugador2 = new int [numFilas] [numColumnas];
		
		/*
		for (int i = 0; i < tableroJugador1.length; i++) {
			for (int j = 0; j < tableroJugador1[i].length; j++) {

				//System.out.println("Coloque en una posición el barco 2 (tamaó = 2)");
				
				
			}
		}
		
		*/
		
		for (int i = 0; i <= numColumnas; i++) {
			System.out.print(i + " ");
			
		}
		System.out.println();
		
		for (int i = 0; i < tableroJugador1.length; i++) {
			System.out.print(k + " " );
			k++;
			for (int j = 0; j < tableroJugador1[i].length; j++) {
				
				System.out.print(+tableroJugador1[i][j] + " ");
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		System.out.println("Jugador 1, posicion X del barco 1 (tamaño = 1)");
		posicionX = TECLADO.nextInt();
		
		System.out.println("Jugador 1, posicion Y del barco 1 (tamaño = 1)");
		posicionY = TECLADO.nextInt();
		
		System.out.println("Jugador 1, posicion X del barco 2 (tamaño = 2)");
		posicionX = TECLADO.nextInt();
		
		System.out.println("Jugador 1, posicion Y del barco 2 (tamaño = 2)");
		posicionY = TECLADO.nextInt();
		
		
		
		
		
		tableroJugador1[posicionX-1][posicionY-1] = 1;		
		
		
		for (int i = 0; i < tableroJugador1.length; i++) {
			for (int j = 0; j < tableroJugador1[i].length; j++) {
				
				System.out.print(tableroJugador1[i][j] + " ");
				
			}
			System.out.println();
		}
		
	}

}
