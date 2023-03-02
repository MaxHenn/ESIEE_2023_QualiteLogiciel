package calculation.process;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculationUtility {

	/**
	 * Give a List of square root number between a and b
	 * 
	 * @param a the starting number. Must be positive and inferior or equal to b.
	 * @param b the ending number. Must be positive
	 * @return A List of Double element with represent all square root number
	 *         between a and b
	 */
	public static List<Double> calculateSquareRoot(int a, int b) throws InvalidParameterException {
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

	/**
	 * {@link calculation.process.CalculationUtility.getStringNumber convert} the
	 * given String into int, then use
	 * 
	 * @param a the starting number
	 * @param b the ending number
	 * @return a List of square Root between the value of a & b
	 * @throws InvalidParameterException
	 */
	public static List<Double> calculateSquareRoot(String a, String b) throws InvalidParameterException {
		int firstNumber = getStringNumber(a);
		int secondNumber = getStringNumber(b);
		return calculateSquareRoot(firstNumber, secondNumber);
	}

	/**
	 * Give a List of Good number between a and b
	 * 
	 * @param a the starting number. Must be positive and inferior or equal to b.
	 * @param b the ending number. Must be positive
	 * @return A List of Double element with represent all square root number
	 *         between a and b
	 */
	public static List<Integer> calculateGoodNumber(int a, int b) throws InvalidParameterException {
		if (a < 0 || b < 0) {
			throw new InvalidParameterException("Parameters must be positive");
		} else if (a > b) {
			throw new InvalidParameterException("Parameter a must be lower than b");
		}

		// Initialize the list of square root number of enough size
		List<Integer> listGoodNumber = new ArrayList<>(b - a + 1);
		for (int it = a; it <= b; it++) {
			int goodNumber = it;
			int goodNumberDecompose = 0;
			while (goodNumber > 10) {
				int numberPart = goodNumber % 10;
				goodNumberDecompose += Math.pow(numberPart, 2);
				goodNumber = goodNumber / 10;
			}
			if (goodNumberDecompose < 10) {
				listGoodNumber.add(it);
			}
		}
		return listGoodNumber;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws InvalidParameterException
	 */
	public static List<Integer> calculateGoodNumber(String a, String b) throws InvalidParameterException {
		int firstNumber = getStringNumber(a);
		int secondNumber = getStringNumber(b);
		return calculateGoodNumber(firstNumber, secondNumber);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private static int getStringNumber(String text) {
		if (text == null || text.trim().isEmpty()) {
			throw new InvalidParameterException("Given text is empty");
		}
		Integer number;
		try {
			number = Integer.valueOf(text);
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("No number found in text");
		}
		return number.intValue();
	}

	public static void main(String[] args) {
		List<Integer> result = calculateGoodNumber(1, 250);
		for (Integer squareNumber : result) {
			System.out.println(squareNumber);
		}
	}
}
