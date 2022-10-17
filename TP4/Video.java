class Video extends Media{
	
	int duree;

	public Video(String titre, int duree){
		super(titre);
		this.duree = duree;
	}

	public String toString(){
		return super.toString() + "\nDurée: " + duree;
	}
}
