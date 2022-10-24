class ChaineCar{
	String texte;

	public int len(){
		return texte.length();
	}

	public String toString(){
		return texte;
	}

	public ChaineCar(){
		texte = "";
	}

	public ChaineCar(String t){
		texte = t;
	}
}
