package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.data.Money;

class MoneyTest {

	private static Money m;
	
	@BeforeAll
	public static void init() {
		m = new Money(20, "EUR");
	}
	
	@Test
	void test() {
		assertTrue(m.amount() > 0);
	}

}
