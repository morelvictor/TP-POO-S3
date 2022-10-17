class Case{
	boolean color; // true -> Blanc ~~ false -> Noir
	Piece piece;

	public Piece getPiece(){ return piece; }
	public boolean isEmpty(){ return piece == null; }
	public void placePiece(Piece p){ if(isEmpty()) piece = p; }
	public void removePiece(){ if(!isEmpty()) piece = null; }

	public Case(boolean color, Piece piece){
		this.color = color;
		this.piece = piece;
	}

	public String toString(){
		if(isEmpty()){
			if(color) return ".";
			return "#";
		}
		return piece.toString().substring(0, 1);
	}
}
