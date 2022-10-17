
class Lanceur{
	
	public static void main(String[] args){
		Joueur j = new Joueur();
		j.setNom(j.demanderNom());
		while(j.veutJouer()){
			int[] dim = j.demanderDimensions();
			int nbMines = j.demanderNbMines();
			Plateau p = new Plateau(dim[1], dim[0], nbMines);
			Jeu jeu = new Jeu(j, p);
			jeu.jouer();
		}
		j.finir();
	}

}
