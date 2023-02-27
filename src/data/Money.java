package src.data;

/**
 * 
 * @author MaxHenn
 */
public class Money {

	private int fAmount;
	private String fCurrency;

	/**
	 * 
	 * @param amount
	 * @param currency
	 */
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	/**
	 * 
	 * @return
	 */
	public int amount() {
		return fAmount;
	}

	/**
	 * 
	 * @return
	 */
	public String currency() {
		return fCurrency;
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public Money add(Money m) {
		if (currency().equals(m.currency())) {
			this.fAmount += m.amount();
		}
		return this;
	}

	/**
	 * 
	 * @param nAmount
	 * @param nCurrency
	 * @return
	 */
	public Money add(int nAmount, String nCurrency) {
		if (currency().equals(nCurrency)) {
			this.fAmount += nAmount;
		}
		return this;

	}

}
