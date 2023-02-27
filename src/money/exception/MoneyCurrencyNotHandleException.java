package money.exception;

public class MoneyCurrencyNotHandleException extends MoneyCurrencyException {
	private static final long serialVersionUID = 1L;

	public MoneyCurrencyNotHandleException(String currency) {
		super("Currency not found : " + currency);
	}
}