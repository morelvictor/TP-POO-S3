
class Palette {
	Vue v;
	Modele m;
	Controleur c;

	public Palette() {
		m = new Modele(0, 100, 0);
		v = new Vue(this, m);
		v.setVisible(true);
		c = new Controleur(m, v);
	}

	public static void main(String[] args) {
		new Palette();
	}
}
