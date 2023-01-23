
public class Libro extends Prodotto {

	private String autore;
	private String genere;

	public Libro(String isbn, String titolo, Integer annoPubblicazione, Integer numPagine, String autore,
			String genere) {
		super(isbn, titolo, annoPubblicazione, numPagine);
		this.autore = autore;
		this.genere = genere;
	}

	// GETTER
	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	// SETTER
	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	
	public static String toStringFile(Libro libro) {
		return Libro.class.getSimpleName() // Serve per identificare il tipo di elemento
				+ "@" + libro.isbn + "@" + libro.titolo + "@" + libro.annoPubblicazione + "@" + libro.numPagine + "@"
				+ libro.autore + "@" + libro.genere;
		//"@" separatore tra le varie proprietà della classe Libro
	}
	
	
	public static Libro fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");
		return new Libro(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5], split[6]);
	}

}
