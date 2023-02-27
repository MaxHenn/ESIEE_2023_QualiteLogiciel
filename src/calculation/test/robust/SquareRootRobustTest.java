package calculation.test.robust;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import calculation.process.CalculationManager;

public class SquareRootRobustTest {

	private static int default_time_seconds = 1;
	private static int number_squareroot_test = 1000;

	@Test
	void testTimeForSquareRoot() {
		assertTimeout(Duration.ofSeconds(default_time_seconds), () -> {
			CalculationManager.calculateSquareRoot(1, number_squareroot_test);
		});
	}

	@Test
	void testTimeForMultipleSquareRoot() {
		assertTimeout(Duration.ofSeconds(default_time_seconds), () -> {
			for (int it = 0; it < number_squareroot_test; it++) {
				CalculationManager.calculateSquareRoot(1, 10);
			}
		});
	}

}
