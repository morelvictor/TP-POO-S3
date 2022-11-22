
public class Controleur {
	Modele m;
	Vue v;

	public Controleur(Modele mod, Vue vue) {
		m = mod;
		v = vue;
	}

	public void sliderMoved() {
		m.r = (int) (((double) v.r.getValue()) * 2.5);
		m.v = (int) (((double) v.v.getValue()) * 2.5);
		m.b = (int) (((double) v.b.getValue()) * 2.5);
	}

	public void memoriser() {
		m.memoire = m.copy();
	}

	public void serappeler() {
		if (m.memoire == null)
			return;
		m.r = m.memoire.r;
		m.v = m.memoire.v;
		m.b = m.memoire.b;
	}

	public void complementaire() {
		m.r = 255 - m.r;
		m.v = 255 - m.v;
		m.b = 255 - m.b;
	}
}
