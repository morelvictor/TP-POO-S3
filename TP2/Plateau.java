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
						if(mines[y + ly][x + lx])
							n++;
					}
				}
				adja[y][x] = n;
			} 
		}
	}
	
	// Voir String.format()
	public void afficheTout(){
		System.out.println("********************");
		System.out.println("* Mines / Drapeaux *");
		System.out.println("*    " + nbMines + " /        " + nbDrapeaux + " * ");
		System.out.println("********************\n");
		
		System.out.print("    ");
		for(int i = 0; i < largeur; i++){
			System.out.print(i + " ");
		}
		System.out.print("\n");
		System.out.print("---");
		for(int i = 0; i < largeur; i++){
			System.out.print("--");
		}
		System.out.print("\n");
		for(int y = 1; y < hauteur + 1; y ++){
			System.out.print(((char) (y + ('a'-1))) + " | ");
			for(int x = 1; x < largeur + 1; x ++){
				char c = (char) (adja[y][x] + '0');
				if(mines[y][x])
					c = '*';
				System.out.print(c + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void revelerCase(int x, int y, boolean ... c){ // La variable c sert a savoir si la fonction est executée par l'ordinatour ou par le joueur
		if(x < 1 || y < 1 || x > largeur || y > hauteur)
			return;
		if(etats[y][x] == 0){
			etats[y][x] = 2;
			if(adja[y][x] == 0){
				for(int ly = -1; ly <= 1; ly++){
					for(int lx = -1; lx <= 1; lx++){
						if(ly == 0 && lx == 0)
							continue;
						revelerCase(x+lx, y+ly, true);
					}
				}
			}
			return;
		}
		if(c.length > 0)
			return;
		System.out.println("La case que vous essayez de reveler est déjà révélé ou a un drapeau.");
	}
	
	public void drapeauCase(int x, int y){
		if(etats[y][x] == 2){
			System.out.println("Case déjà révélée, impossible d'y placer un drapeau.");
			return;
		}
		if(etats[y][x] == 0){
			etats[y][x] = 1;
			nbDrapeaux ++;
		}else{
			etats[y][x] = 0;
			nbDrapeaux --;
		}
	}

	public void afficheCourant(){
		System.out.println("********************");
		System.out.println("* Mines / Drapeaux *");
		System.out.println("*    " + nbMines + " /        " + nbDrapeaux + " * ");
		System.out.println("********************\n");
		
		System.out.print("    ");
		for(int i = 0; i < largeur; i++){
			System.out.print(i + " ");
		}
		System.out.print("\n");
		System.out.print("---");
		for(int i = 0; i < largeur; i++){
			System.out.print("--");
		}
		System.out.print("\n");
		for(int y = 1; y < hauteur + 1; y ++){
			System.out.print(((char) (y + ('a'-1))) + " | ");
			for(int x = 1; x < largeur + 1; x ++){
				char c = (char) (adja[y][x] + '0');
				if(etats[y][x] == 0)
					c = '.';
				if(etats[y][x] == 1)
					c = '!';
				System.out.print(c + " ");
			}
			System.out.print("\n");
		}
	}
	
	public boolean jeuPerdu(){
		for(int y = 1; y<hauteur+1; y++){
			for(int x =1; x<largeur+1; x++){
				if(mines[y][x]){
					if(etats[y][x] == 2)
						return true;
				}
			}
		}
	return false;
	}

	public boolean jeuGagne(){
		for(int y = 1; y < hauteur + 1; y++){
			for(int x = 1; x < largeur + 1; x++){
				if(mines[y][x]) continue;
				if(etats[y][x] == 0) return false;
			}
		}
		return true;
	}
}














