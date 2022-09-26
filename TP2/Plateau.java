class Plateau{
	private int hauteur;
	private int largeur;
	private int nbMines;
	private int nbDrapeaux;
	private boolean[][] mines;
	private int[][] etats;
	private int[][] adja;

	public Plateau(int ha, int la, int mi){
		hauteur = ha;
		largeur = la;
		nbMines = mi;
		// Dans les trois tableaux suivants
		// le plateau de jeu "utile" sera contenu
		// dans la diagonale de coordonée (1, 1) et (ha, la)
		// pour faciliter les calculs (d'ou le +2)
		mines = new boolean[ha + 2][la + 2]; 
		etats = new int[ha + 2][la + 2];
		adja = new int[ha + 2][la + 2];
		ajouteMinesAlea();
		calculeAdjacence();
	}
	
	private void ajouteMinesAlea(){
		for(int i = 0; i < nbMines; i++){
			int x = Usefull.random(1, largeur);
			int y = Usefull.random(1, hauteur);
			if(mines[y][x]){
				i--;
			}else{
				mines[y][x] = true;
			}
		}
	}
	
	private void calculeAdjacence(){
		for(int y = 1; y < hauteur; y++){
			for(int x = 1; x < largeur; x++){
				if(mines[y][x])
					continue;
				int n = 0;
				for(int ly = -1; ly <= 1; ly++){
					for(int lx = -1; lx <= 1; lx++){
						if(ly == 0 && lx == 0)
							continue;
						if(mines[y][x])
							n++;
					}
				}
				adja[y][x] = n;
			} 
		}
	}
	
	public void afficheTout(){
		
	}

}
