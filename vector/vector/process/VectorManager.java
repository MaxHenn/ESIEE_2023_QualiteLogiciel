package vector.process;

import java.util.Vector;

public class VectorManager {
	
	/**
	 * Give the union between two Vector containing Integers
	 * @param a the first Vector
	 * @param b the second Vector
	 * @return a third Vector containing all unique Integer from a & b
	 */
	public static Vector<Integer> unionSet(Vector<Integer> a, Vector<Integer> b) {
		a.addAll(b);
		Vector<Integer> c = new Vector<Integer>(a.size() + b.size());
		for (Integer integer : a) {
			if (!c.contains(integer)) {
				c.add(integer);
			}
		}
		return c;
	}

	public static void main(String[] args) {

	}
}
