package calculation.test.unit;

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
	void testAIsSuperiorToB() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(default_a + default_b, default_b);
		});
	}

	@Test
	void testAIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(-default_a, default_b);
		});
	}

	@Test
	void testBIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listSquareRoot = CalculationUtility.calculateSquareRoot(default_a, -default_b);
		});
	}

}
