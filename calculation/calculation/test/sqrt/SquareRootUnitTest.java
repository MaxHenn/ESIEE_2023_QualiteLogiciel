package calculation.test.sqrt;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculation.process.CalculationUtility;

public class SquareRootUnitTest {

	private static int default_a = 1;
	private static int default_b = 5;
	private static List<Double> listSquareRoot;

	@BeforeEach
	public void cleanList() {
		listSquareRoot = new LinkedList<Double>();
	}

	@AfterEach
	public void verifyList() {
		for (Double number : listSquareRoot) {
			assertFalse(number < 0);
		}
	}

	@Test
	public void testCalculate() {
		assertDoesNotThrow(() -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(default_a, default_b);
		});
	}

	@Test
	public void testCalculateGoodValue() {
		int value = 4;
		assertDoesNotThrow(() -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(value, value);
		});
		assertEquals(Math.sqrt(value), listSquareRoot.get(0));
	}

	@Test
	public void testAIsSuperiorToB() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(default_a + default_b, default_b);
		});
	}

	@Test
	public void testAIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(-default_a, default_b);
		});
	}

	@Test
	public void testBIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(default_a, -default_b);
		});
	}

	@Test
	public void testValidString() {
		assertDoesNotThrow(() -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(String.valueOf(default_a), String.valueOf(default_b));
		});
	}

	@Test
	public void testInvalidString() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(String.valueOf(default_a), "Invalid");
		});
	}

	@Test
	public void testEmptyString() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot("", String.valueOf(default_b));
		});
	}

	@Test
	public void testNullString() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(String.valueOf(default_a), null);
		});
	}

}
