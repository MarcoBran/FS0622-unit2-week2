package Package;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
	private static final Logger Logger = LoggerFactory.getLogger(Banca.class);
	
	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1750.5);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			Logger.error("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

		ContoOnline conto2 = new ContoOnline("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(2000);

			conto2.stampaSaldo();

		} catch (BancaException e) {
			Logger.error("Errore durante il prelievo: " + e,e);
			e.printStackTrace();
		}
	}

}


//Esercizio #3
//DATE LE SEGUENTI CLASSI









/*Creare un nuovo tipo di eccezione: la classe BancaException sottoclasse della classe Exception avente l’attributo message di tipo stringa. Scrivere il costruttore con un parametro di tipo stringa, dopo aver richiamato il costruttore della superclasse passando il parametro impostare il valore
dell’attributo message uguale al parametro. Ridefinire il metodo toString che restituisce un stringa, il metodo restituisce il valore di message.

Modificare il metodo preleva della classe ContoCorrente in modo che se saldo dopo la sottrazione è minore di zero il metodo lancia una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il conto è in rosso” ed aumentando comunque il contatore dei movimenti.

Modificare il metodo preleva della sottoclasse ContoOnLine in modo che se x>maxPrelievo viene lanciata una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il prelievo non è disponibile”.

Modificare la classe Banca in modo da catturare l’eccezione di tipo BancaException e stampare l’errore ogni volta che si richiama il metodo preleva
*/