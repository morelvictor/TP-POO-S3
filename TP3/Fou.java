
class Fou extends Piece{
	public Fou(boolean couleur){
		super(couleur, "fou");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.typeDeplacement() != 'd') return false;
		if(d.pieceEntre(p)) return false;
		return true;
	}
}
