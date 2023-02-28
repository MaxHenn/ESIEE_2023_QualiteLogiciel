package money.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import money.data.*;
import money.exception.*;

class MoneyBagTest {

	private static MoneyBag bag;

	@BeforeAll
	public static void init() {
		bag = new MoneyBag();
	}

	@Test
	public void testCreateBag() {
		int amount = 10;
		String currency = MoneyType.EUR.name();
		MoneyBag moneyBag = new MoneyBag();
		try {
			moneyBag.add(amount, currency);
			assertEquals(moneyBag.getCurrencyAmount(currency), amount);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testAddBag() {
		int amount = 10;
		String currency = MoneyType.EUR.name();
		MoneyBag moneyBag = new MoneyBag();
		try {
			moneyBag.add(amount, currency);
			Money money = new Money(amount, currency);
			moneyBag.add(money);
			moneyBag.add(bag);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testAddSubBagCurrency() {
		int amount = 10;
		String currency = MoneyType.CHF.name();
		MoneyBag moneyBag = new MoneyBag();
		assertDoesNotThrow(() -> {
			moneyBag.add(amount, currency);
			assertEquals(moneyBag.getCurrencyAmount(currency), amount);
			moneyBag.sub(amount, currency);
			assertEquals(moneyBag.getCurrencyAmount(currency), 0);
			assertTrue(moneyBag.hasCurrency(currency));
		});
	}

	@Test
	public void testAddMultipleCurrency() {
		int amount = 10;
		String currencyEuro = MoneyType.EUR.name();
		String currencyDollar = MoneyType.USD.name();
		try {
			bag.add(amount, currencyEuro);
			bag.add(amount, currencyDollar);
			assertEquals(bag.getCurrencyAmount(currencyEuro), amount);
			assertEquals(bag.getCurrencyAmount(currencyDollar), amount);
			bag.add(new Money(amount, currencyEuro));
			assertEquals(bag.getCurrencyAmount(currencyEuro), amount * 2);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testMoneyBagSubIntoNegative() {
		int amount = 10;
		String currency = MoneyType.EUR.name();
		MoneyBag moneyBag = new MoneyBag();
		try {
			moneyBag.sub(amount, currency);
			assertTrue(moneyBag.getCurrencyAmount(currency) < 0);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testMoneyBagSubMoneyIntoNegative() {
		int amount = 10;
		String currency = MoneyType.CHF.name();
		MoneyBag moneyBag = new MoneyBag();
		try {
			Money money = new Money(amount, currency);
			moneyBag.sub(money);
			assertTrue(moneyBag.getCurrencyAmount(currency) < 0);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testMoneyBagSubMoneyBagIntoNegative() {
		int amount = 10;
		String currency = MoneyType.GBP.name();
		MoneyBag moneyBag = new MoneyBag();
		try {
			MoneyBag moneyBag2 = new MoneyBag();
			moneyBag2.add(amount, currency);
			moneyBag.sub(moneyBag2);
			assertTrue(moneyBag.getCurrencyAmount(currency) < 0);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testCreateBagAllMoneyCurrency() {
		int amount = 10;
		MoneyBag moneyBag = new MoneyBag();
		assertDoesNotThrow(() -> {
			for (MoneyType moneyType : MoneyType.values()) {
				Money money = new Money(amount, moneyType.name());
				moneyBag.add(money);
			}
		});
	}

}
