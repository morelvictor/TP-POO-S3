class TitreCommencePar extends Predicat{
	char lettre;
	
	public TitreCommencePar(char lettre){
		this.lettre = lettre;
	}

	public boolean estVrai(Media doc){
		if(doc.getTitre().length() == 0)
			return false;
		if(doc.getTitre().charAt(0) == Character.toLowerCase(lettre) || doc.getTitre().charAt(0) == Character.toUpperCase(lettre))
			return true;
		return false;
	}
}
