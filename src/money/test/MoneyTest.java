package money.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import money.data.Money;
import money.data.MoneyType;
import money.exception.MoneyCurrencyNotHandleException;

class MoneyTest {

	private static Money m;
	private static int start_amount = 20;
	private static String start_currency = MoneyType.EUR.name();

	@BeforeAll
	public static void init() {
		try {
			m = new Money(start_amount, start_currency);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			System.exit(-1);
		}
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

	@BeforeEach
	void testMoneyStatus() {
		assertTrue(m.amount() > 0);
		assertTrue(m.currency().length() == 3);
	}

	@Test
	void testAddAmount() {
		int mAmount = m.amount();
		int amount = 5;
		String currency = start_currency;
		m.add(amount, currency);
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	void testAddNegativeAmount() {
		int mAmount = m.amount();
		int amount = -5;
		String currency = start_currency;
		m.add(amount, currency);
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	void testAddMoney() {
		Money money;
		try {
			money = new Money(start_amount * 2, start_currency);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			return;
		}
		int moneyAmount = money.amount();
		money.add(m);
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
		int moneyAmount = money.amount();
		money.add(m);
		assertEquals(money.amount(), moneyAmount);
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

	private static void createFalseMoney(int amount) throws MoneyCurrencyNotHandleException {
		Money money = new Money(amount, "Chocolat");
		money.add(10, "Vanille");
	}

}