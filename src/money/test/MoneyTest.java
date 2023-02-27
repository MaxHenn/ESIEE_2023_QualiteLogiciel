package money.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import money.data.*;
import money.exception.*;

class MoneyTest {

	private static Money m;
	private static int start_amount = 20;
	private static String start_currency = MoneyType.EUR.name();

	@BeforeEach
	public static void init() {
		try {
			m = new Money(start_amount, start_currency);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
			System.exit(-1);
		}
		assertTrue(m.amount() > 0);
		assertTrue(m.currency().length() == 3);
	}

	@Test
	public static void createNegativeAmount() {
		int amount = -1;
		Money money;
		try {
			money = new Money(amount, start_currency);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			return;
		}
		assertNotEquals(money.amount(), amount);
	}

	@Test
	void testAddAmount() {
		int mAmount = m.amount();
		int amount = 5;
		String currency = start_currency;
		try {
			m.add(amount, currency);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
			return;
		}
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	void testAddNegativeAmount() {
		int mAmount = m.amount();
		int amount = -5;
		String currency = start_currency;
		try {
			m.add(amount, currency);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
			return;
		}
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	void testAddMoney() {
		Money money;
		int moneyAmount = start_amount * 2;
		try {
			money = new Money(moneyAmount, start_currency);
			money.add(m);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
			return;
		}
		assertEquals(money.amount(), moneyAmount + m.amount());
	}

	@Test
	void testAddInvalidCurrencyMoney() {
		Money money;
		String currency = MoneyType.GBP.name();
		assertNotEquals(m.currency(), currency);
		try {
			money = new Money(start_amount, currency);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			return;
		}
		assertThrows(MoneyCurrencyNotEqualsException.class, () -> {
			money.add(m);
		});
	}

	@Test
	void testCreationAllKnownCurrencyMoney() {
		assertDoesNotThrow(() -> {
			for (MoneyType moneyType : MoneyType.values()) {
				new Money(start_amount, moneyType.name());
			}
		});
	}

	@Test
	void testAddUnknownCurrencyMoney() {
		assertThrows(MoneyCurrencyNotHandleException.class, () -> {
			createFalseMoney(start_amount);
		});
	}

	private static void createFalseMoney(int amount) throws MoneyCurrencyException {
		Money money = new Money(amount, "Chocolat");
		money.add(10, "Vanille");
	}

}
