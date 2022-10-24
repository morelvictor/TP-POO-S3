public abstract class Figure{
	private int posX;
	private int posY;

	public Figure(int x, int y){
		posX = x;
		posY = y;
	}

	public final int getPosX(){ return posX; }
	public final int getPosY(){ return posY; }

	public abstract void affiche();

	public double estDistanteDe(Figure fig){
		return Math.sqrt(Math.pow(this.posX - fig.getPosX(), 2) + Math.pow(this.posY - fig.getPosY(), 2));
	}

	public abstract double surface();

	public void deplacement(int x, int y){
		posX += x;
		posY += y;
	}

}
