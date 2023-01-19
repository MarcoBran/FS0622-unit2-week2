package week2Giorno2Esercizio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.slf4j.LoggerFactory;
/*
 * ESERCIZIO#2
 * SCRIVERE UNA FUNZIONE CHE ACCETTI UN INTERO N E RESTITUISCA UNA LISTA ORDINATA DI N INTERI CASUALI DA 0 A 100.
 * SCRIVERE UNA SECONDA FUNZIONE CHE ACCETTI UNA LISTA E RESTITUISCA UNA NUOVA LISTA COMPOSTA DAGLI ELEMENTI DELLA PRIMA LISTA 
 * SEGUITI DAGLI STESSI ELEMENTI DISPOSTI IN ORDINE INVERSO.
 * SCRIVERE UNA TERZA FUNZIONE CHE ACCETTI UNA LISTA ED UN BOOLEANO: SE IL BOOLEANO è TRUE STAMPA I VALORI IN POSIZIONE PARI,
 * ALTRIMENTI STAMPA I VALORI IN POSIZIONE DISPARI.
 * CREARE UNA MAIN CHE UTILIZZI LE DUE FUNZIONI.
 * UTILIZZARE L'INTERFACCIA LIST E L'IMPLEMENTAZIONE ARRAYLIST.
 */

public class Main {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listaRandom = inizializzaListaRandom(5);
		
		stampaLista(listaRandom);
		
		stampaLista(listaRandom, true);
		
		stampaLista(listaRandom, false);
		
		List<Integer> listaSpeculare = listaSpeculare(listaRandom);
		
		stampaLista(listaSpeculare);
	}
	
	private static List<Integer> inizializzaListaRandom(int numElementi){
		List<Integer> listaElementi = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		for(int i = 0; i < numElementi; i++) {
			listaElementi.add(randomGenerator.nextInt(101));
		}
		return listaElementi;
	}
	
	private static List<Integer> listaSpeculare(List<Integer> listaOriginale){
		//Crea una nuova lista contenente gli elementi della lista originale
		List<Integer> nuovaLista = new ArrayList<Integer>(listaOriginale);
		
		for(int i = listaOriginale.size() - 1; i >= 0; i--) {
			nuovaLista.add(listaOriginale.get(i));
		}
		return nuovaLista;
	}
	
	private static void stampaLista (List<Integer> lista, boolean pari) {
		System.out.println("Stampa Lista " + (pari ?  "PARI" : "DISPARI"));
		
		if(pari == true) {
			for(int i = 0; i < lista.size(); i = i + 2) {
				System.out.println("Posizione [" + i + "]: " + lista.get(i));
			}
		} else {
			for(int i = 1; i < lista.size(); i = i+2) {
				System.out.println("Posizione [" + i + "]: " + lista.get(i));
			}
		}
		
	}
	
	private static void stampaLista(List<Integer> lista) {
		System.out.println("Stampa lista");
		for(Integer curInt : lista) {
			System.out.println("Posizione [" + lista.indexOf(curInt) + "]: " + curInt);
		}
	}
	
}
















