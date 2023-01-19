package week2Giorno2Esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/*
 * ESERCIZIO#1
 * SCRIVERE UN PROGRAMMA CHE CHIEDA ALL'UTENTE DI INSERIRE UN INTERO N CHE RAPPRESENTI IL NUMERO DI ELEMENTI DA
 * INSERIRE E POI GLI CHIEDA DI INSERIRE N PAROLE.
 * IL PROGRAMMA DOVRà:
 * -STAMPARE TUTTE LE PAROLE DUPLICATE;
 * -STAMPARE IL NUMERO DI PAROLE DISTINTE;
 * -STAMPARE L'ELENCO DELLE PAROLE DISTINTE.
 * UTILIZZARE L'INTERFACCIA SET E L'IMPLEMENTAZIONI HASHSET
 */

public class Main {
	
	public static final org.slf4j.Logger Logger = LoggerFactory.getLogger(Main.class);
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Set<String> setParole = new HashSet<String>();
		
		boolean continua = true;
		
		do {
			try {
				System.out.println("Inserisci il numero di elementi, seguito dal tasto invio. digitare 0 per uscire.");
				//E' necessario perchè usando nextInt, poi lo scanner ha un comportamento
				//inatteso con il successivo comando nextLine
				
				int numElementi = Integer.valueOf(scanner.nextLine());
				
				if(numElementi == 0) {
					continua = false;
				} else {
					for(int i = 0; i < numElementi; i++) {
						System.out.println("Inserisci una parola seguita dal tasto invio");
						String parola = scanner.nextLine();
						
						//Aggiunge la parola al set. Se il set contiene già la parola,
						//essa non viene aggiunta e ritorna "false", altrimenti "true"
						
						boolean parolaAggiunta = setParole.add(parola);
						
						if(!parolaAggiunta) {
							//Se la parola non è stata aggiunta è un duplicato
							System.out.println("Parola duplicata: " + parola);
						}
					}
					
					System.out.println("Numero parole distinte: " + setParole.size());
					
					System.out.println("Parole distinte: ");
					//Itera su tutti gli elementi del set
					for(String parolaCorrente : setParole) {
						System.out.println("- " + parolaCorrente);
					}
					//svuota il set
					setParole.clear();
				}
			} catch(Exception e) {
				Logger.error("Errore. La procedura riprenderà dall'inizio");
				//svuota il set
				setParole.clear();
			}
		} while(continua == true);
		System.out.println("Programma terminato");
		scanner.close();
	}
}
