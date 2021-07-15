package br.com.luisgomes.casaDoCodigoTreino.apiErrors;

public class CategoriaNaoEcontradaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoriaNaoEcontradaException(String msg) {
		super(msg);
	}
}
