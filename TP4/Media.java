class Media{
	static int current_id = 0;
	private final String titre;
	private final int id;
	
	public Media(String titre){
		this.titre = titre;
		id = current_id;
		current_id += 1;
	}

	public String getTitre(){
		return this.titre;
	}

	public int getId(){
		return this.id;
	}

	public String toString(){
		return "id: " + id + "\ntitre: " + titre;
	}

	public boolean plusPetit(Media doc){
		if(this.ordreMedia() < doc.ordreMedia())
			return true;
		return id < doc.getId();
	}

	public int ordreMedia(){
		if(this instanceof Livre)return 1;
		if(this instanceof BandeDessinee)return 2;
		if(this instanceof Manga)return 3;
		if(this instanceof Video)return 4;
		if(this instanceof LongMetrage)return 5;
		if(this instanceof Image)return 6;
		return 0;
	}
}
