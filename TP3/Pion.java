class Pion extends Piece{
	public Pion(boolean couleur){
		super(couleur, "pion");
	}

	public boolean estValide(Deplacement d, Plateau p){
		if(!super.estValide(d, p)) return false;
		if(d.dist() > 2) return false;
		if(color){
			if(d.y0 <= d.y1) return false;
		}else{
			if(d.y0 >= d.y1) return false;
		}
		if(d.typeDeplacement() == 'v'){
			if(d.pieceEntre(p)) return false;
			if(moved){
				if(d.dist() > 1) return false;
			}
		}
		if(d.typeDeplacement() == 'd'){
			if(d.dist() > 1) return false;
			if(p.getCase(d.x1, d.y1).piece == null) return false;
		}
		return true;
	}
}
