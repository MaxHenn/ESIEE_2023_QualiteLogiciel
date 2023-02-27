package money.exception;

public class MoneyCurrencyNotEqualsException extends MoneyCurrencyException {
	private static final long serialVersionUID = 1L;

	public MoneyCurrencyNotEqualsException() {
		super("Currency are not equals");
	}

	public MoneyCurrencyNotEqualsException(String currentCurrency, String newCurrency) {
		super("Currency are not equals : " + currentCurrency + " / " + newCurrency);
	}
}