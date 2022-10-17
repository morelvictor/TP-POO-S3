class LongMetrage extends Video{
	String realisateur;

	public LongMetrage(String titre, int duree, String realisateur){
		super(titre, duree);
		this.realisateur = realisateur;
	}
}
