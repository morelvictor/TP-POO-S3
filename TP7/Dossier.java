import java.util.List;
import java.util.LinkedList;

public class Dossier extends Element implements Affichable {
	private List<Entree> l;
	private Dossier parent;

	public Dossier(Dossier p) {
		l = new LinkedList<>();
		parent = p;
	}

	public String getType() {
		return "Dossier";
	}

	public void supprimer(Entree e) {
		l.remove(e);
	}

	public Dossier getParent() {
		return parent;
	}

	public void setParent(Dossier p) {
		parent = p;
	}

	public void ajouter(Element e, String nom) {
		l.add(new Entree(this, nom, e));
	}

	public void ajouter(Element e) {
		l.add(new Entree(this, "untitled", e));
	}

	public void afficher() {
		for (Entree e : l) {
			System.out.println(e);
		}
	}

	public Entree getEntree(String nom, boolean creer) {
		for (Entree e : l) {
			if (e.getNom() == nom)
				return e;
		}
		if (creer) {
			l.add(new Entree(this, nom, null));
		}
		return getEntree(nom, creer);
	}
}
