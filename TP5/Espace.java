
class Espace extends ChaineCar{
	
	int size;

	public Espace(int s){
		size = s;
	}

	public int len(){
		return size;
	}

	public void setSize(int s){
		size = s;
	}

	public String toString(){
		return " ".repeat(size); // je n'utilises pas l'implémentation proposé dans le tp car elle est plus longue.
	}
}
