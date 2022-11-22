
public class Modele {
	int r;
	int v;
	int b;

	Modele memoire;

	public Modele(int r, int v, int b) {
		this.r = r;
		this.v = v;
		this.b = b;
	}

	public Modele(int r, int v, int b, Modele mem) {
		this(r, v, b);
		memoire = mem;
	}

	public Modele copy() {
		return new Modele(r, v, b, memoire);
	}
}
