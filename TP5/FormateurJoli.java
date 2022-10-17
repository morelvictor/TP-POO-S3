class FormateurJoli extends Formateur{
	int maxLength;
	
	public FormateurJoli(String filename, int ml){
		super(filename);
		this.maxLength = ml;
	}
}
