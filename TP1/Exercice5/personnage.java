
class Personnage{
  private String nom;
  private Informations etatInitial;
  private Informations etatActuel;
  
  public Personnage(String nom, Informations inf){
    this.nom = nom;
    this.etatInitial = inf;
    this.etatActuel = new Informations(inf);
  }

  public String getNom(){ return nom; }
  public Informations getEtatInitial(){ return etatInitial; }
  public Informations getEtatActuel(){ return etatActuel; }

  public boolean estVivant(){ return etatActuel.getVitalite() > 0; }
  public void rebirth(){ etatActuel.setVitalite(etatInitial.getVitalite()); }

	public String toString(){
		return nom + ":\n" + etatActuel;
	}

	// La formule donné dans le tp a un problème 
	// dans le cas ou forceAttaquant == forceDefenseur, n = 1 et n/2 = 0
  public void attaque(Personnage def){
    int n = Util.random(
				1, 
				Math.max(1, etatActuel.getForce() - def.getEtatActuel().getForce()));
		if(def.getEtatActuel().getAgilite() < etatActuel.getAgilite()){
      def.getEtatActuel().setVitalite(def.getEtatActuel().getVitalite() - Math.max(1, n));
    }else{
      def.getEtatActuel().setVitalite(def.getEtatActuel().getVitalite() - Math.max(1, (n/2)));
      def.getEtatActuel().setAgilite(def.getEtatActuel().getAgilite()/3);
    }
  }

  public void lutteIter(Personnage def){
    boolean p = true; // Variable qui permet de savoir qui doit attaquer
    while(estVivant() && def.estVivant()){
      System.out.println(this);
      System.out.println(def);
      if(p){
        attaque(def);
        p = !p;
      }else{
        def.attaque(this);
        p = !p;
      }
    }
    System.out.println("Le combat est fini");
  }

	public void lutteRec(Personnage def){
		if(!estVivant() || !def.estVivant()){
			System.out.println("Le combat est fini");
		}else{
			attaque(def);
			System.out.println(this);
			System.out.println(def);
			def.lutteRec(this);
		}
	}
}
