package calculation.process;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculationManager {

	/**
	 * Give a List of square root number between a and b
	 * 
	 * @param a the starting number. Must be positive and inferior or equal to b.
	 * @param b the ending number. Must be positive
	 * @return A List of Double element with represent all square root number
	 *         between a and b
	 */
	public static List<Double> calculateSquareRoot(int a, int b) {
		if (a < 0 || b < 0) {
			throw new InvalidParameterException("Parameters must be positive");
		} else if (a > b) {
			throw new InvalidParameterException("Parameter a must be lower than b");
		}

		// Initialize the list of square root number of enough size
		List<Double> listSquareRoot = new ArrayList<>(b - a + 1);
		for (int it = a; it <= b; it++) {
			listSquareRoot.add(Math.sqrt(it));
		}
		return listSquareRoot;
	}

	public static void main(String[] args) {
		List<Double> result = calculateSquareRoot(1, 5);
		for (Double squareNumber : result) {
			System.out.println(squareNumber);
		}
	}
}
