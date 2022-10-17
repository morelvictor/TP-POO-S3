class Livre extends Media{
	String auteur;
	int nbPages;

	public Livre(String titre, String auteur, int nbPages){
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public String toString(){
		return super.toString() + "\nauteur: " + auteur + "\nnbPages: " + nbPages;
	}

}
