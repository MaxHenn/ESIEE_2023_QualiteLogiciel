package vector.process;

import java.util.Vector;

public class VectorManager {
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
