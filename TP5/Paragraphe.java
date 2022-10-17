import java.util.LinkedList;

class Paragraphe extends ChaineCar{
	LinkedList<Ligne> l;
	
	public Paragraphe(){
		l = new LinkedList<>();
	}

	public int len(){
		int acc = 0;
		for(Ligne e : l){
			acc += e.len();
		}
		return acc;
	}

	public String toString(){
		String acc = "";
		for(Ligne e : l){
			acc += e.toString();
			if(e != l.getLast())
				acc += "\n";
		}
		return acc;
	}

	public boolean isEmpty(){
		return l.isEmpty();
	}

	public void addChaine(ChaineCar c){
		if(isEmpty()){
			l.add(new Ligne(c));
		}else{
			l.getLast().addChaine(c);
		}
	}

	public void addLigne(Ligne ligne){
		l.add(ligne);
	}
}
