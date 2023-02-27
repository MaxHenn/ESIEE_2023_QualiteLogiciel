package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.data.Money;

class MoneyTest {

	private static Money m;
	private static int start_amount = 20;
	private static String start_currency = "EUR";

	@BeforeAll
	public static void init() {
		m = new Money(start_amount, start_currency);
	}

	@BeforeAll
	public static void createNegativeAmount() {
		int amount = -1;
		Money money = new Money(amount, start_currency);
		assertNotEquals(money.amount(), amount);
	}

	@Before
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
		Money money = new Money(start_amount * 2, start_currency);
		int mAmount = m.amount();
		m.add(money);
		assertEquals(m.amount(), mAmount + money.amount());
	}

}
