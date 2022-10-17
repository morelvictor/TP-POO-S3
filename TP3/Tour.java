
class Tour extends Piece{
	public Tour(boolean couleur){
		super(couleur, "tour");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.typeDeplacement() != 'v' && d.typeDeplacement() != 'h') return false;
		if(d.pieceEntre(p)) return false;
		return true;
	}
}
