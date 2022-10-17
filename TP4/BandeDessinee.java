class BandeDessinee extends Livre{
	String dessinateur;

	public BandeDessinee(String titre, String auteur, int nbPages, String dessinateur){
		super(titre, auteur, nbPages);
		this.dessinateur = dessinateur;
	}
}
