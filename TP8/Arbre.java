
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arbre {
	public class Noeud {
		String nom;
		int taille;
		boolean repertoire;
		ArrayList<Noeud> fils;

		public Noeud(File f) throws FileNotFoundException {
			if (!f.exists())
				throw new FileNotFoundException();

			nom = f.getName();
			taille = (int) f.length();
			repertoire = f.isDirectory();
			if (f.isDirectory()) {
				fils = new ArrayList<>();
				File[] files = f.listFiles();
				for (int i = 0; i < files.length; i++) {
					fils.add(new Noeud(files[i]));
				}
			}
		}

		public void afficher(int n) {
			System.out.println(" ".repeat(n) + nom + " [" + taille + "]");
			if (repertoire) {
				for (Noeud f : fils) {
					f.afficher(n + 2);
				}
			}
		}

		public void map(StringTransformation t) {
			if (repertoire)
				fils.forEach((Noeud n) -> {
					n.map(t);
				});
			else
				nom = t.transf(nom);
		}

		public void traverser(String extension) {
			if (repertoire)
				fils.forEach((Noeud n) -> {
					n.traverser(extension);
				});
			else if (nom.endsWith("." + extension))
				System.out.println(nom + " [" + taille + "]");
		}

		public boolean supprimer(String extension) {
			boolean deleted = false;
			if (repertoire) {
				ArrayList<Noeud> l = new ArrayList<>();
				fils.forEach((Noeud n) -> {
					if (n.repertoire) {
						l.add(n);
						n.supprimer(extension);
					} else if (!n.nom.endsWith("." + extension))
						l.add(n);

				});
				if (!fils.equals(l))
					deleted = true;
				fils = l;
			}
			return deleted;
		}
	}

	Noeud racine;

	public Arbre(String path) throws FileNotFoundException {
		racine = new Noeud(new File(path));
	}

	public void afficher() {
		racine.afficher(0);
	}

	public void map(StringTransformation t) {
		racine.map(t);
	}

	public void traverser(String extension) {
		racine.traverser(extension);
	}

	public void supprimer(String extension) throws UnableToDeleteFileException {
		if (!racine.supprimer(extension))
			throw new UnableToDeleteFileException();
	}

	public static void main(String[] args) {
		StringTransformation addBlah = (String s) -> {
			return s + ".blah";
		};
		try {
			Arbre a = new Arbre("./path");
			a.afficher();
			System.out.println("--------------");
			a.traverser("txt");
			System.out.println("--------------");
			try {
				a.supprimer("txt");
			} catch (UnableToDeleteFileException e) {
				System.out.println("Pas de suppression");
			}
			a.afficher();
			System.out.println("--------------");
			a.map(addBlah);
			a.afficher();
		} catch (FileNotFoundException e) {
			System.out.println("Non");
		}

		System.out.println("-----------------------");

		System.out.println(addBlah.transf("hey"));
		System.out.println("-----------------------");

	}
}
