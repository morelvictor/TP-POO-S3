class Combat{
  

  public static void main(String[] args){
    Informations inf = new Informations(100, 100, 100);
    Personnage p1 = new Personnage("P1", inf);
    Personnage p2 = new Personnage("P2", inf);
    p1.lutteIter(p2);
  }
}
