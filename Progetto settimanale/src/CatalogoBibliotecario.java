import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

/*
  * Creare le classi necessarie a gestire un catalogo bibliotecario.
  * Il catalogo è formato da elementi che possono essere libri o riviste.
  * Sia Libri che Riviste hanno i seguenti attributi:
  * - Codice ISBN (codice univoco);
  * - Anno pubblicazione;
  * - Numero pagine.
  * 
  * I Libri hanno inoltre: 
  * - Autore;
  * - Genere.
  * 
  * Le riviste hanno:
  * - Periodicità [SETTIMANALE, MENSILE, SEMESTRALE].
  * 
  * L'archivio deve permettere le seguenti operazioni:
  * - Aggiunta di un elemento;
  * - Rimozione di un elemento dato un codice ISBN;
  * - Ricerca per ISBN;
  * - Ricerca per anno di pubblicazione; 
  * - Ricerca per Autore;
  * - Salvataggio su disco dell'Archivio;
  * - Scaricamento dal disco dell'Archivio.
  * 
  * Per l'implementazione degli algoritmi si impieghino i Java Streams e le Lambda expression.
  */

public class CatalogoBibliotecario {

	private static final Logger Logger = LoggerFactory.getLogger(CatalogoBibliotecario.class);

	private static final String FILE_PATH = "c:\\...";

	private Map<String, Prodotto> archivio; // String è la chiave univoca, Prodotto è il valore

	public CatalogoBibliotecario() {
		this.archivio = new HashMap<String, Prodotto>();
	}

	public void aggiungi(Prodotto nuovoProdotto) {
		archivio.put(nuovoProdotto.getIsbn(), nuovoProdotto);
		Logger.info("Elemento aggiunto in archivio. Isbn: {} - Anno di pubblicazione: {} ", nuovoProdotto.getIsbn(),
				nuovoProdotto.getAnnoPubblicazione());
	}

	public void rimuovi(String isbn) {
		Prodotto prodottoRimosso = archivio.remove(isbn);
		if (prodottoRimosso != null)
			Logger.info("Elemento rimosso dall'archivio. ISBN: {} - Anno di pubblicazione: {}",
					prodottoRimosso.getIsbn(), prodottoRimosso.getAnnoPubblicazione());
	}

	public Prodotto ricercappperIsbn(String isbn) {
		return archivio.get(isbn);
	}

	public List<Prodotto> ricercaPerAnnoPubblicazione(Integer annoPubblicazione) {
		return archivio.values().stream().filter(elem -> annoPubblicazione.equals(elem.getAnnoPubblicazione()))
				.collect(Collectors.toList());
	}

	public List<Libro> ricercaPerAutore(String autore) {
		return archivio.values().stream().filter(elem -> elem instanceof Libro) //Seleziona solo le istanze di Libro
				.map(elem -> (Libro) elem) //Effettua un cast a Libro
				.filter(elem -> autore.equals(elem.getAutore())) //Seleziona libri con autore indicato
				.collect(Collectors.toList()); //Ritorna una lista di elementi
	}

	public void salvaCatalogo() throws IOException{
		String fileString = "";
		
		for(Prodotto prodotto : archivio.values()) {
			if(fileString.length() != 0) {
				fileString += "#"; 
			}
			if(prodotto instanceof Libro) {
				fileString += Libro.toStringFile((Libro) prodotto);
			} else if(prodotto instanceof Rivista) {
				fileString += Rivista.toStringFile((Rivista) prodotto);
			}
		}
		
		File file = new File(FILE_PATH);
		FileUtils.writeStringToFile(file, fileString, "UTF-8");
		Logger.info("Dati salvati correttamente sul file" + FILE_PATH);
	}
	
	public void caricaCatalogo() throws IOException{
		this.archivio.clear();
		
		File file = new File(FILE_PATH);
		
		String fileString = FileUtils.readFileToString(file, "UTF-8");
		
		List<String> splitElementiString = Arrays.asList(fileString.split("#"));
		
		for(String curString : splitElementiString) {
			Prodotto prodotto = null;
			if(curString.startsWith(Libro.class.getSimpleName())) {
				prodotto = Libro.fromStringFile(curString);
			} else if(curString.startsWith(Rivista.class.getSimpleName())){
				prodotto = Rivista.fromStringFile(curString);	
			}
			this.archivio.put(prodotto.getIsbn(), prodotto);
		}
		Logger.info("Dati caricati correttamente dal file " + FILE_PATH);
	}
	
	


	public static void main(String[] args) {
		
		CatalogoBibliotecario catalogo = new CatalogoBibliotecario();
		
		Libro l1 = new Libro("1111111", "Eleven rings. L'anima del successo", 2013, 336, "Phil Jackson", "Biografia");
		Rivista r1 = new Rivista("1111112", "Weekly Shonen Jump", 1969, 256, Periodicita.SETTIMANALE);
		
		catalogo.aggiungi(r1);
		catalogo.aggiungi(l1);
		
		try {
			catalogo.salvaCatalogo();
			
			catalogo.caricaCatalogo();
			
			List<Libro> ricercaPerAutore = catalogo.ricercaPerAutore("Phil Jackson");
			
			ricercaPerAutore.forEach(elem -> System.out.println("Titolo: " + elem.getTitle()));
			
		} catch (IOException) {
			Logger.error("errore durante la lettura/scrittura", e);
		}

	}


	
	
}
