class Manga extends BandeDessinee{
	boolean sensInverse;

	public Manga(String titre, String auteur, int nbPages, String dessinateur, boolean sensInverse){
		super(titre, auteur, nbPages, dessinateur);
		this.sensInverse = sensInverse;
	}
}
