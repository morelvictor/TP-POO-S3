
class Dame extends Piece{
	public Dame(boolean couleur){
		super(couleur, "dame");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.typeDeplacement() != 'd' && d.typeDeplacement() != 'v' && d.typeDeplacement() != 'h') return false;
		if(d.pieceEntre(p)) return false;
		return true;
	}

}
