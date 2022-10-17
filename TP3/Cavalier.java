
class Cavalier extends Piece{
	public Cavalier(boolean couleur){
		super(couleur, "cavalier");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.typeDeplacement() != 'c') return false;
		return true;
	}
}
