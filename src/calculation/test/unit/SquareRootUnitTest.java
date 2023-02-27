package calculation.test.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import calculation.process.CalculationManager;

public class SquareRootUnitTest {

	private static int default_a = 1;
	private static int default_b = 5;

	@Test
	void testAIsSuperiorToB() {
		assertThrows(InvalidParameterException.class, () -> {
			CalculationManager.calculateSquareRoot(default_a + default_b, default_b);
		});
	}

	@Test
	void testAIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			CalculationManager.calculateSquareRoot(-default_a, default_b);
		});
	}

	@Test
	void testBIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			CalculationManager.calculateSquareRoot(default_a, -default_b);
		});
	}

}
