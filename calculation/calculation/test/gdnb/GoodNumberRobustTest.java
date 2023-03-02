package calculation.test.gdnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import calculation.process.CalculationUtility;

public class GoodNumberRobustTest {

	private static int default_time_seconds = 1;
	private static int number_goodnumer_test = 1000;

	@Test
	public void testTimeForSignleSquareRoot() {
		int valueTested = 747;
		assertTimeout(Duration.ofMillis(10), () -> {
			CalculationUtility.calculateGoodNumber(valueTested, valueTested);
		});
	}

	@Test
	public void testTimeForSquareRoot() {
		assertTimeout(Duration.ofSeconds(default_time_seconds), () -> {
			CalculationUtility.calculateGoodNumber(default_time_seconds, number_goodnumer_test);
		});
	}

	@Test
	public void testTimeForMultipleSquareRoot() {
		int start = 1, end = 10;
		assertTimeout(Duration.ofSeconds(default_time_seconds), () -> {
			for (int it = 0; it < number_goodnumer_test; it++) {
				CalculationUtility.calculateGoodNumber(start, end);
			}
		});
	}

}
