class Rectangle extends Figure implements Deformable{
	final double hauteur;
	final double largeur;

	public Rectangle(int centreX, int centreY, double largeur, double hauteur){
		super(centreX, centreY);
		this.hauteur = hauteur;
		this.largeur = largeur;
	}

	public void affiche(){}

	public Figure deformation(double coeffH, double coeffV){
		return new Rectangle(this.getPosX(), this.getPosY(), this.largeur * coeffH,this.hauteur * coeffV);
	}

	public double surface(){
		return hauteur * largeur;
	}
}
