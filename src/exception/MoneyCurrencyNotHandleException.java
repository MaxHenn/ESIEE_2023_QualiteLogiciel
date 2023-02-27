package src.exception;

public class MoneyCurrencyNotHandleException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoneyCurrencyNotHandleException(String currency) {
		super("Currency not found : " + currency);
	}
}