package calculation.process;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculationManager {

	public static List<Double> calculateSquareRoot(int a, int b) {
		if (a < 0 || b < 0) {
			throw new InvalidParameterException("Parameters must be positive");
		} else if (a < b) {
			throw new InvalidParameterException("Parameter a must be lower than b");
		}

		List<Double> listSquareRoot = new ArrayList<>(b - a);
		for (int it = a; it < b; it++) {
			listSquareRoot.add(Math.sqrt(it));
		}
		return listSquareRoot;
	}

	public static void main(String[] args) {
	}
}
