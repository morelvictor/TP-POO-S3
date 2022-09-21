

class Informations{
  
  private int v; // Vitalite
  private int f; // Force
  private int a; // Agilite

  public Informations(int v, int f, int a){
    this.v = v;
    this.f = f;
    this.a = a;
  }

  public Informations(Informations inf){
    this.v = inf.v;
    this.f = inf.f;
    this.a = inf.a;
  }

  public int getVitalite(){ return this.v; }
  public int getForce(){ return this.f; }
  public int getAgilite(){ return this.a; }

  public void setVitalite(int v){
    this.v = v;
  }

  public void setForce(int f){
    this.f = f;
  }

  public void setAgilite(int a){
    this.a = a;
  }

  public String toString(){
    return ("Informations:\n  - Vitalité: " + v + "\n  - Force: " + f + "\n  - Agilité: " + a);
  }

}
