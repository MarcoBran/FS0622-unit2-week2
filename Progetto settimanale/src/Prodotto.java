
public abstract class Prodotto {
	
	//"protected" --> visibile solo nelle classi che lo estendono
	protected String isbn;
	protected String titolo;
	protected Integer annoPubblicazione;
	protected Integer numPagine;
	
	public Prodotto(String isbn, String titolo, Integer annoPubblicazione, Integer numPagine) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numPagine = numPagine;
	}
	 //GETTER
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return titolo;
	}
	
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	public int getNumPagine() {
		return numPagine;
	}
	
	//SETTER
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String titolo) {
		this.titolo = titolo;
	}
	
	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	
	public void setNumPagine(Integer numPagine) {
		this.numPagine = numPagine;
	}
	
	public String printProdotto() {
		return "Prodotto - ISBN: " + this.isbn + " - Titolo: " + this.titolo + " - Anno di pubblicazione: " + this.annoPubblicazione + " - Numero delle pagine: " + this.numPagine; 
	}
}
