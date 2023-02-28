package money.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import money.data.*;
import money.exception.*;

class MoneyTest {

	private static Money m;
	private static int default_amount = 20;
	private static String default_currency = MoneyType.EUR.name();

	@BeforeEach
	public void init() {
		assertDoesNotThrow(() -> {
			m = new Money(default_amount, default_currency);
		});
		assertTrue(m.amount() > 0);
		assertTrue(m.currency().length() == 3);
	}

	@Test
	public void createNegativeAmount() {
		int amount = -1;
		assertDoesNotThrow(() -> {
			Money money = new Money(amount, default_currency);
			assertNotEquals(money.amount(), amount);
		});
	}

	@Test
	public void createSameMoney() {
		assertDoesNotThrow(() -> {
			Money money = new Money(default_amount, default_currency);
			assertEquals(money.amount(), m.amount());
			assertEquals(money.currency(), m.currency());
			assertTrue(money.equals(m));
		});
	}

	@Test
	public void testAddAmount() {
		int mAmount = m.amount();
		int amount = 5;
		assertDoesNotThrow(() -> {
			m.add(amount, default_currency);
		});
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	public void testAddNegativeAmount() {
		int mAmount = m.amount();
		int amount = -5;
		assertDoesNotThrow(() -> {
			m.add(amount, default_currency);
		});
		assertEquals(m.amount(), mAmount + amount);
	}

	@Test
	public void testAddMoney() {
		Money money;
		int moneyAmount = default_amount * 2;
		try {
			money = new Money(moneyAmount, default_currency);
			money.add(m);
		} catch (MoneyCurrencyException ex) {
			fail(ex.toString());
			return;
		}
		assertEquals(money.amount(), moneyAmount + m.amount());
	}

	@Test
	public void testAddInvalidCurrency() {
		String currency = MoneyType.GBP.name();
		assertNotEquals(m.currency(), currency);
		assertThrows(MoneyCurrencyNotEqualsException.class, () -> {
			m.add(default_amount, currency);
		});
	}

	@Test
	public void testAddInvalidCurrencyMoney() {
		Money money;
		String currency = MoneyType.GBP.name();
		assertNotEquals(m.currency(), currency);
		try {
			money = new Money(default_amount, currency);
		} catch (MoneyCurrencyNotHandleException ex) {
			fail(ex.toString());
			return;
		}
		assertThrows(MoneyCurrencyNotEqualsException.class, () -> {
			money.add(m);
		});
	}

	@Test
	public void testCreationAllKnownCurrencyMoney() {
		assertDoesNotThrow(() -> {
			for (MoneyType moneyType : MoneyType.values()) {
				new Money(default_amount, moneyType.name());
			}
		});
	}

	@Test
	public void testCreateUnknownCurrencyMoney() {
		assertThrows(MoneyCurrencyNotHandleException.class, () -> {
			createFalseMoney(default_amount);
		});
	}

	@Test
	public void testAddUnknownCurrencyMoney() {
		assertThrows(MoneyCurrencyNotHandleException.class, () -> {
			addFalseMoney(m, default_amount);
		});
	}

	private static void createFalseMoney(int amount) throws MoneyCurrencyException {
		Money money = new Money(amount, "Chocolat");
		addFalseMoney(money, amount);
	}

	private static void addFalseMoney(Money money, int amount) throws MoneyCurrencyException {
		money.add(amount, "Vanille");
	}

}
