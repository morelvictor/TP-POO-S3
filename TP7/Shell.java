class Shell {
	private Dossier racine;
	private Dossier courant;

	public Shell(Dossier d) {
		while (d.getParent() != null) {
			d = d.getParent();
		}
		this.racine = d;
		this.courant = d;
	}

	public void cat(String nom) {
		Entree e = courant.getEntree(nom, false);
		if ((e.getElement() instanceof FichierTexte)) {
			((FichierTexte) e.getElement()).afficher();
		}
		if ((e.getElement() instanceof Dossier)) {
			System.out.println("cette commande n'est pas utilisable sur ce type d'élément");
		}
		if (e.getElement() == null) {
			System.out.println("cette entrée est vide");
		}
	}

	public void cd(String nom) {
		Entree e = courant.getEntree(nom, false);
		if ((e.getElement() instanceof Dossier)) {
			courant = (Dossier) (e.getElement());
		}
		if ((e.getElement() instanceof FichierTexte)) {
			System.out.println("cette commande n'est pas utilisable sur ce type d'élément");
		}
		if (e.getElement() == null) {
			System.out.println("cette entrée est vide");
		}
	}

	public void ls(String nom) {
		if (nom.equals(""))
			courant.afficher();
		else {
			Entree e = courant.getEntree(nom, false);
			if ((e.getElement() instanceof Dossier)) {
				((Dossier) e.getElement()).afficher();
			}
			if ((e.getElement() instanceof FichierTexte)) {
				System.out.println("cette commande n'est pas utilisable sur ce type d'élément");
			}
			if (e.getElement() == null) {
				System.out.println("cette entrée est vide");
			}
		}
	}

	public void mkdir(String nom) {
		courant.ajouter(new Dossier(courant), nom);
	}

	public void rm(String nom) {
		Entree e = courant.getEntree(nom, false);
		if (e.getElement() instanceof Dossier) {
			System.out.println("cette commande n'est pas utilisable sur ce type d'élément");
		} else {
			e.supprimer();
		}
	}

}
