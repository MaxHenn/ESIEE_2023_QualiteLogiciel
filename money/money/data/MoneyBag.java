package money.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import money.exception.*;

public class MoneyBag {

	private Map<String, Money> bag;

	public MoneyBag() {
		bag = new HashMap<String, Money>();
	}

	public boolean hasCurrency(String nCurrency) {
		return bag.containsKey(nCurrency);
	}

	public void add(int amount, String currency) throws MoneyCurrencyException {
		if (hasCurrency(currency)) {
			bag.get(currency).add(amount, currency);
		} else {
			bag.put(currency, new Money(amount, currency));
		}
	}

	public void add(Money m) throws MoneyCurrencyException {
		add(m.amount(), m.currency());
	}

	public void add(MoneyBag bag) throws MoneyCurrencyException {
		for (Entry<String, Money> money : bag.getBag().entrySet()) {
			add(money.getValue());
		}
	}

	public void sub(int amount, String currency) throws MoneyCurrencyException {
		if (hasCurrency(currency)) {
			bag.get(currency).add(-amount, currency);
		} else {
			bag.put(currency, new Money(0, currency));
			bag.get(currency).add(-amount, currency);
		}
	}

	public void sub(Money m) throws MoneyCurrencyException {
		sub(m.amount(), m.currency());
	}

	public void sub(MoneyBag bag) throws MoneyCurrencyException {
		for (Entry<String, Money> money : bag.getBag().entrySet()) {
			sub(money.getValue());
		}
	}

	public Map<String, Money> getBag() {
		return bag;
	}

	public int getCurrencyAmount(String currency) {
		Money m = bag.get(currency);
		if (m == null) {
			return 0;
		}
		return m.amount();
	}

}
