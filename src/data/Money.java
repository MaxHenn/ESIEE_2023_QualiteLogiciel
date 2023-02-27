package src.data;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to link a amount with a currency
 * 
 * @author MaxHenn
 */
public class Money {

	private int amount;
	private String currency;

	private static List<String> currencyType = new ArrayList<String>(Arrays.asList("EUR", "USD", "CHF", "GBP"));

	/**
	 * Create a new Money instance
	 * 
	 * @param amount
	 * @param currency
	 */
	public Money(int amount, String currency) {
		if (amount < 0) {
			amount = 0;
		}
		if (!currencyType.contains(currency)) {
			currency = currencyType.get(0);
		}
		this.amount = amount;
		this.currency = currency;
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
	 * @param m The Money to compare
	 * @return true if both currency and amount are the same
	 */
	public boolean equals(Money m) {
		return (this.currency().equals(m.currency()) && (this.amount() == m.amount()));
	}

}
