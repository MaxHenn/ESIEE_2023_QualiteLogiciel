/**
 * 
 */
package calculation.test.gdnb;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculation.process.CalculationUtility;

/**
 * @author maxen
 *
 */
public class GoodNumberUnitTest {

	private static int default_a = 1;
	private static int default_b = 5;
	private static List<Integer> listGoodNumer;

	@BeforeEach
	public void cleanList() {
		listGoodNumer = new LinkedList<Integer>();
	}

	@AfterEach
	public void verifyList() {
		for (Integer number : listGoodNumer) {
			assertFalse(number < 0);
		}
	}

	@Test
	public void testCalculate() {
		assertDoesNotThrow(() -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(default_a, default_b);
		});
	}

	@Test
	public void testCalculateGoodValue() {
		// Test Value is set to 300 (which pass) and 302 (which fail)
		int start = 300, end = 302;
		assertDoesNotThrow(() -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(start, end);
		});
		assertEquals(start, listGoodNumer.get(0));
		for (Integer integer : listGoodNumer) {
			assertNotEquals(end, integer);
		}
	}

	@Test
	public void testAIsSuperiorToB() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(default_a + default_b, default_b);
		});
	}

	@Test
	public void testAIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(-default_a, default_b);
		});
	}

	@Test
	public void testBIsNegative() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(default_a, -default_b);
		});
	}

	@Test
	public void testValidString() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(String.valueOf(default_a), String.valueOf(default_b));
		});
	}

	@Test
	public void testInvalidString() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(String.valueOf(default_a), "Invalid");
		});
	}

	@Test
	public void testEmptyString() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber("", String.valueOf(default_b));
		});
	}

	@Test
	public void testNullString() {
		assertThrows(InvalidParameterException.class, () -> {
			listGoodNumer = CalculationUtility.calculateGoodNumber(String.valueOf(default_a), null);
		});
	}

}
