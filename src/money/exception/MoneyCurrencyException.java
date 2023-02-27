package money.exception;

public class MoneyCurrencyException extends Exception {
	private static final long serialVersionUID = 1L;

	public MoneyCurrencyException(String errorMessage) {
		super(errorMessage);
	}
}
