package vector.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import vector.process.VectorManager;

class VectorTest {

	@Test
	void test() {
		Vector<Integer> a = new Vector<Integer>();
		Vector<Integer> b = new Vector<Integer>();
		VectorManager.unionSet(a, b);
	}

}
