package src.data;

import src.exception.MoneyCurrencyNotHandleException;

/**
 * Class to link a amount with a currency
 * 
 * @author MaxHenn
 */
public class Money {

	private int amount;
	private String currency;

	/**
	 * Create a new Money instance
	 * 
	 * @param amount
	 * @param currency
	 * @throws MoneyCurrencyNotHandleException
	 */
	public Money(int amount, String currency) throws MoneyCurrencyNotHandleException {
		if (amount < 0) {
			amount = 0;
		}
		if (!isCurrencyValid(currency)) {
			throw new MoneyCurrencyNotHandleException(currency);
		}
		this.amount = amount;
		this.currency = currency;
	}

	/**
	 * Check if the given currency is in the MoneyType Enums
	 * 
	 * @param currency the currency to check
	 * @return true if the currency is found, false otherwise
	 */
	private boolean isCurrencyValid(String currency) {
		for (MoneyType type : MoneyType.values()) {
			if (type.name().equals(currency)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the current amount
	 */
	public int amount() {
		return amount;
	}

	/**
	 * @return the currency
	 */
	public String currency() {
		return currency;
	}

	/**
	 * Add into the Money instance the amount of the other Money if the currency are
	 * equals
	 * 
	 * @param m another Money instance to add
	 * @return This Money Object
	 */
	public Money add(Money m) {
		if (currency().equals(m.currency())) {
			this.amount += m.amount();
		}
		return this;
	}

	/**
	 * Add into the Money instance the given amount if the currency is the same.
	 * Warning : amount can be negative
	 * 
	 * @param nAmount
	 * @param nCurrency
	 * @return
	 */
	public Money add(int nAmount, String nCurrency) {
		if (currency().equals(nCurrency)) {
			this.amount += nAmount;
		}
		return this;
	}

	/**
	 * Check if two Money instance are equals
	 * 
	 * @param m The Money to compare
	 * @return true if both currency and amount are the same
	 */
	public boolean equals(Money m) {
		return (this.currency().equals(m.currency()) && (this.amount() == m.amount()));
	}

}
