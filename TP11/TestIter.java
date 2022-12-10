import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {
	private E[] tableau;
	int index = -1;

	public E next() throws IllegalStateException {
		if (!hasNext())
			throw new IllegalStateException();
		index += 1;
		return tableau[index];
	}

	public boolean hasNext() {
		return index + 1 < tableau.length && tableau[index + 1] != null;
	}

	public TestIter(E[] t) {
		this.tableau = t;
	}

	public static void main(String[] args) {
		Integer[] t = { 0, 1, 2, 3, 4 };
		TestIter<Integer> iter = new TestIter<>(t);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
