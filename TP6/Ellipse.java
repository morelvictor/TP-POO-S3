class Ellipse extends Figure{
	// L'implémentation proposée ne permet d'implementer Deformation de maniere convenable
	final double grand_rayon;
	final double petit_rayon;

	public Ellipse(int centreX, int centreY, double g_rayon, double p_rayon){
		super(centreX, centreY);
		grand_rayon = g_rayon;
		petit_rayon = p_rayon;
	}


	public void affiche(){}
	
	public double surface(){
		return Math.PI * grand_rayon * petit_rayon;
	}
}
