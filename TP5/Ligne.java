import java.util.LinkedList;

class Ligne extends ChaineCar{
	LinkedList<ChaineCar> l;
	
	public Ligne(){
		l = new LinkedList<>();
	}

	public Ligne(ChaineCar c){
		LinkedList<ChaineCar> lacc = new LinkedList<>();
		lacc.add(c);
		this.l = lacc;
	}

	public int len(){
		int acc = 0;
		for(ChaineCar c : l){
			acc += c.len();
		}
		return acc;
	}

	public String toString(){
		String acc = "";
		for(ChaineCar c : l){
			acc += c.toString();
		}
		return acc;
	}

	public boolean isEmpty(){
		return l.isEmpty();
	}

	public void addChaine(ChaineCar c){
		l.add(c);
	}
}
