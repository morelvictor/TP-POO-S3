import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
	String contenu;

	public String getType() {
		return "texte";
	}

	public void afficher() {
		System.out.println(contenu);
	}

	public void editer(Scanner sc, boolean echo) {
		contenu = "";
		while (sc.hasNext()) {
			String n = sc.next();
			if (n.equals("."))
				return;
			contenu += n + "\n";
			if (echo)
				System.out.println(n);
		}
	}
}
