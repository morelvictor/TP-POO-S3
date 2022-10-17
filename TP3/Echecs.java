class Echecs{
	
	boolean joueur = true;

	public static void main(String[] args){
		Plateau p = new Plateau(4, 8);
		p.placePiece(2, 2, new Roi(true));
		p.print();
		Deplacement d = new Deplacement(2, 2, 3, 3);
		Echecs jeu = new Echecs();

		jeu.jouerTour(d, true, p);
	}

	public void jouerTour(Deplacement d, boolean joueur, Plateau p){
		// Les conditions demandées dans le Question 2 sont vérifiées dans les fonction "estValide()" de chaque sous classe de Piece.
		
		if(p.outside(d))
			return;
		if(p.getCase(d.x0, d.y0).piece.estValide(d, p)){
			p.removePiece(d.x1, d.y1);
			p.placePiece(d.x1, d.y1, p.getCase(d.x0, d.y0).piece);
			p.removePiece(d.x0, d.y0);
		}
		p.print();
	}
}
