class Combat{
  

  public static void main(String[] args){
    Informations inf1 = new Informations(100, 100, 100);
		Informations inf2 = new Informations(100, 15, 30);
    Personnage p1 = new Personnage("P1", inf1);
		Personnage p2 = new Personnage("P2", inf2);
    p1.lutteRec(p2);
	}
}
