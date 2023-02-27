package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import src.data.Money;
import src.data.MoneyBag;
import src.exception.MoneyCurrencyNotHandleException;

class MoneyBagTest {

	private static MoneyBag bag;

	@BeforeAll
	public static void init() {
		int amount = 10;
		String currency = "EUR";
		bag = new MoneyBag();
		try {
			bag.add(10, currency);
			assertEquals(bag.getCurrencyAmount(currency), amount);
			bag.add(new Money(10, currency));
			assertEquals(bag.getCurrencyAmount(currency), amount * 2);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			System.exit(-1);
		}
	}

	@Test
	public void createBag() {
		int amount = 10;
		String currency = "EUR";
		MoneyBag moneyBag = new MoneyBag();
		try {
			moneyBag.add(amount, currency);
			assertEquals(moneyBag.getCurrencyAmount(currency), amount);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
		}
	}

}
