package Package;

public class BancaException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public BancaException(String msg) {
		super(msg);
		this.message = msg;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
