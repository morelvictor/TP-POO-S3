class ParagrapheJoli extends Paragraphe{
	int maxLength;

	public ParagrapheJoli(int ml){
		super();
		this.maxLength = ml;
		this.addChaine(new Espace(4));
	}

	public void addChaine(ChaineCar c){
		if(isEmpty()){
			l.add(new Ligne(c));
		}else{
			if(l.getLast().len() + c.len() > maxLength && l.getLast().len() > 0){
				l.add(new Ligne(c));
			}else{
				l.getLast().addChaine(c);
			}
		}
	}

}
