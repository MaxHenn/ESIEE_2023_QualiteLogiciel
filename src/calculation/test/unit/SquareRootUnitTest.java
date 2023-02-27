package calculation.test.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import calculation.process.CalculationManager;

public class SquareRootUnitTest {

	private static int default_a = 1;
	private static int default_b = 5;
	private static List<Double> listSquareRoot;

	@Before
	public static void cleanList() {
		listSquareRoot = new LinkedList<Double>();
	}

	@After
	public static void verifyList() {
		for (Double number : listSquareRoot) {
			if (number < 0) {
				fail("A given value is negative");
			}
		}
	}

	@Test
	void testAIsSuperiorToB() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationManager.calculateSquareRoot(default_a + default_b, default_b);
		});
	}

	@Test
	void testAIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationManager.calculateSquareRoot(-default_a, default_b);
		});
	}

	@Test
	void testBIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationManager.calculateSquareRoot(default_a, -default_b);
		});
	}

}
