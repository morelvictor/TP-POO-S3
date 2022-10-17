
class Roi extends Piece{
	public Roi(boolean couleur){
		super(couleur, "roi");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.dist() > 1) return false;
		return true;
	}
}
