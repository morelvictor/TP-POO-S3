class Jeu{
	Joueur j;
	Plateau p;

	public Jeu(Joueur j, Plateau p){
		this.j = j;
		this.p = p;
	}

	public void jouer(){
		while(!p.jeuGagne()){
			if(p.jeuPerdu()){
				p.afficheTout();
				return;
			}
			p.afficheCourant();
			char a = j.demanderAction();
			int[] coord = j.demanderCoordonnes();
			switch(a){
				case 'r':
					p.revelerCase(coord[0], coord[1]);
					break;
				case 'd':
					p.drapeauCase(coord[0], coord[1]);
					break;
				default:
					break;
			}
			System.out.println("Gagne: " + p.jeuGagne());
		}
	}
}
