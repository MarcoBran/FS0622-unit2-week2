package week2Giorno1Esercizio2;

/*
 * SCRIVERE UN PROGRAMMA CHE PERMETTA DI CALCOLARE IL NUMERO DI KM/LITRO PERCORSI DA UN'AUTO.
 * IL PROGRAMMA RICEVE DALL'UTENTE IL NUMERO DI KM PERCORSI ED I LITRI DI CARBURANTE CONSUMATI E STAMPA I KM/LITR PERCORSI.
 * GESTIRE PER MEZZO DEL TRY-CATCH L'EVENTUALITà CHE L'UTENTE INSERISCA IL VALORE 0 PER IL NUMERO DI LITRI CONSUMATI E VENGA GENERATA 
 * UNA ECCEZIONE DI DIVISIONE PER ZERO.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int kilometri, litri, distanza;
		
		try {
			System.out.print("Inserire i kilometri percorsi: ");
			kilometri = scanner.nextInt();
			System.out.print("Inserire i litri di benzina consumati: ");
			litri = scanner.nextInt();
			
			distanza = kilometri / litri;
			
			System.out.println("La tua auto percorre " + distanza + " kilometri al litro.");
		} catch (ArithmeticException ex) {
			//INTERCETTA L'ECCEZIONE DI DIVISIONE PER 0
			System.out.println("Impossibile che la tua macchina non consumi carburante: " + ex.getMessage());
			//STAMPA IN CONSOLE LO STCKTRACE DELL'ECCEZIONE
			ex.printStackTrace();
		} catch(Exception ex) {
			//INTERCETTA QUALSIASI ALTRA ECCEZIONE
			System.out.println("Questo è un altro tipo di errore: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		System.out.println("Fine del programma.");
		scanner.close();
	}

}
