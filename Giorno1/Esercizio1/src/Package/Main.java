package Package;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

/*Scrivere un programma che istanzi un array di 5 interi con valori casuali tra 1 e 10 e lo stampi in console,
 chieda all'utente di inserire un numero in una posizione specificata e stampi il nuovo stato dell'array,
 ripetere l'operazione fino a che l'utente non inserisce il valore 0.
 Gestire eventuali errori dovuti alla violazione dei limiti dell'array.
 */

public class Main {

	//GENERA NUMERI CASUALI INTERI COMPRESI TRA 0 E 10
	
	public static void main(String[] args) {
		
		int[] array = creaArrayCasuale();
		
		stampaArray(array);
		
		leggiNumeroPosizione(array);
		
	}
	
	private static void leggiNumeroPosizione(int[] array) {
		Scanner in = new Scanner(System.in);
		int numero, posizione;
		boolean continua = true;
		do {
			System.out.println("Inserire un numero seguito dal tasto invio. Inserire 0 per uscire.");
			numero = in.nextInt();
			if(numero != 0) {
				System.out.println("Inserire la posizione in cui inserire il numero seguita dal tasto invio.");
				posizione = in.nextInt();			
				try {
					array[posizione] = numero;
					stampaArray(array);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Posizione fuori dal limite dell'array: " + posizione);
				}
			} else {
				continua = false;
			}
		} while (continua);
		in.close();
	}
	
	private static void stampaArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println("Valore posizione " + i + ": " + array[i]);
		}
	}
	
	private static int[] creaArrayCasuale() {
		int[] array = new int[5];
		//istazia l'oggetto random che permette di ottenere numeri casuali
		Random randomGenerator = new Random();
		for(int i = 0; i < array.length; i++) {
			//inserisce in posizione i-esima un valore casuale compreso tra 0 e 10
			array[i] = randomGenerator.nextInt(11);
		}
		return array;
		
	}

}