import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {
	private E[] tableau;
	int index;

	public E next() throws IllegalStateException{
		if(index >= tableau.length || index < 0){
			throw new IllegalStateException();
		}else {
			if(tableau[index] == null)
				throw new IllegalStateException();
		}
		return tableau[index];
	}

	public boolean hasNext(){
		return index < tableau.length;
	}
}
