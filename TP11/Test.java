
import java.util.Set;
import java.util.HashSet;

public class Test {

	public static void test() throws Exception {
		TabSet<Integer> i = new TabSet(10);
		i.add(10);
		i.add(20);
		i.add(30);
		i.add(40);
		i.add(40);

		System.out.println(i);

		i.remove(20);
		System.out.println(i);

		Set<Integer> s = new HashSet<>();
		s.add(10);

		i.removeAll(s);
		System.out.println(i);

		s.add(110);
		i.addAll(s);
		System.out.println(i);

		i.retainAll(s);
		System.out.println(i);

		System.out.println("Done");
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
