
public class Entree {
	private Element element;
	private String nom;
	private Dossier parent;

	public Entree(Dossier p, String n, Element e) {
		element = e;
		nom = n;
		parent = p;
	}

	public String toString() {
		if (element.getType() == null)
			return nom + " (entrée vide)";
		return nom + " (" + element.getType() + ")";
	}

	public String getNom() {
		return nom;
	}

	public Element getElement() {
		return element;
	}

	public void supprimer() {
		parent.supprimer(this);
	}

	public void remplacer(Element e) {
		if (e instanceof FichierTexte) {
			element = e;
		}
		if (element instanceof Dossier && e instanceof Dossier) {
			Dossier d = (Dossier) e;
			d.setParent(((Dossier) element).getParent());
		}
	}

	public Dossier getParent() {
		return this.parent;
	}
}
