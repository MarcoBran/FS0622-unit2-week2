package week2Giorno2Esercizio3;

import java.util.HashMap;
import java.util.Map;

/*
 * ESERCIZIO#3
 * SCRIVERE UNA CLASSE JAVA CHE PERMETTA DI GESTIRE UNA RUBRICA TELEFONICA.
 * LA LISTA DEI CONTATTI è REALIZZATA MEDIANTE UNA HASHMAP IN CUI LE CHIAVI SONO I NOMI DELLE PERSONE E I VALORI SONO I NUMERI DI TELEFONO.
 * REALIZZARE I METODI PER:
 * 1.L'INSERIMENTO DI UNA COPPIA <NOME, TELEFONO>;
 * 2.LA CANCELLAZIONE DI UNA COPPIA <NOME, TELEFONO> A PARTIRE DAL NOME;
 * 3.LA RICERCA DI UNA PERSONA DI CUI SI CONOSCE IL NUMERO DI TELEFONO;
 * 4.LA RICERCA DEL NUMERO DI TELEFONO DI UNA PERSONA DI CUI SI CONOSCE IL NOME;
 * 5.LA STAMPA DI TUTTI I CONTATTI CON NOME E NUMERO.
 */

public class Main {
	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void aggiungiContatto(String numero, String nome) throws Exception{
		if(rubrica.containsKey(nome)) {
			throw new Exception("Contatto già presente in rubrica");
		} else {
			rubrica.put(nome, numero);
		}
	}
	
	public void rimouviContatto(String nome) {
		rubrica.remove(nome);
	}
	
	public String ricercaNumero(String nome) {
		return rubrica.get(nome);
	}
	
	public String ricercaPersona(String numero) {
		String trovato = null;
		for(String curPersona : rubrica.keySet()) {
			if(numero.equals(rubrica.get(curPersona)))
				trovato = curPersona;
		}
		return trovato;
	}
	
	public void stampaRubrica() {
		System.out.println("Rubrica");
		for(String curPersona : rubrica.keySet()) {
			System.out.println("Nome: " + curPersona + " -  Numero: " + rubrica.get(curPersona));
		}
	}

}







