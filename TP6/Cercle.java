class Cercle extends Ellipse{
	final double rayon;

	public Cercle(int centreX, int centreY, double r){
		super(centreX, centreY, r, r);
		rayon = r; // C'est un peu inutile car on aurait pu appeler this.grand_rayon par exemple
	}
}
