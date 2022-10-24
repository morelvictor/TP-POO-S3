class Triangle extends Figure implements Deformable{
	final double base;
	final double hauteur;

	public Triangle(int centreX, int centreY, double base, double hauteur){
		super(centreX, centreY);
		this.base = base;
		this.hauteur = hauteur;
	}


	public void affiche(){}

	public Triangle deformation(double coeffH, double coeffV){
		return new Triangle(this.getPosX(), this.getPosY(), this.base * coeffH, this.hauteur * coeffV);
	}

	public double surface(){
		return base * hauteur / 2;
	}
}
