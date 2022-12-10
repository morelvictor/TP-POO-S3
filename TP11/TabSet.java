
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

class TabSet<E> implements Set<E> {
	E[] tab;

	class TabIter implements Iterator<E> {
		int index = -1;

		public E next() throws IllegalStateException {
			if (!hasNext())
				throw new IllegalStateException();
			index += 1;
			return tab[index];
		}

		public boolean hasNext() {
			while (index < tab.length - 1) {
				if (tab[index + 1] != null)
					return true;
				index += 1;
			}
			return false;
		}

		public void remove() throws IllegalStateException {
			if (index == -1)
				throw new IllegalStateException();
			tab[index] = null;
		}

	}

	public Iterator<E> iterator() {
		return new TabIter();
	}

	@SuppressWarnings("unckecked")
	public TabSet(int n) {
		tab = (E[]) new Object[n];
	}

	public boolean contains(Object o) {
		for (E e : this) {
			if (e.equals(o))
				return true;
		}
		return false;
	}

	public int size() {
		int acc = 0;
		for (E e : this) {
			acc += 1;
		}
		return acc;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean add(E e) {
		if (e == null) {
			System.out.println("L'élement est null");
			return false;
		}
		if (contains(e)) {
			System.out.println("L'élément est déjà contenu dans l'ensemble");
			return false;
		}
		if (size() == tab.length) {
			System.out.println("Il n'y a plus de place dans l'ensemble");
			return false;
		}
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				tab[i] = e;
				break;
			}
		}
		return true;
	}

	public boolean remove(Object o) {
		TabIter it = new TabIter();
		while (it.hasNext()) {
			if (it.next() == o) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (E e : this) {
			remove(e);
		}
	}

	public boolean containsAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		while (it.hasNext()) {
			if (!contains(it.next()))
				return false;
		}
		return true;
	}

	public boolean addAll(Collection<? extends E> c) {
		Iterator<?> it = c.iterator();
		boolean acc = true;
		while (it.hasNext()) {
			if (!add((E) it.next()))
				acc = false;
		}
		return acc;
	}

	public boolean removeAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		boolean acc = true;
		while (it.hasNext()) {
			if (!remove(it.next()))
				acc = false;
		}
		return acc;
	}

	public boolean retainAll(Collection<?> c) {
		boolean acc = true;
		for (E e : this) {
			if (!c.contains(e)) {
				if (!remove(e))
					acc = false;
			}
		}
		return acc;
	}

	public Object[] toArray() {
		Object[] acc = new Object[size()];
		int i = 0;
		for (E e : this) {
			acc[i] = e;
			i++;
		}
		return acc;
	}

	public <T> T[] toArray(T[] a) {
		if (a.length >= size()) {
			int i = 0;
			for (E e : this) {
				a[i] = (T) e;
				i += 1;
			}
		}
		return a;
	}

	public String toString() {
		String acc = "";
		for (E e : this) {
			acc += e.toString() + "\n";
		}
		return acc;
	}

}
