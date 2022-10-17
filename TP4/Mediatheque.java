import java.util.ArrayList;

class Mediatheque{
	ArrayList<Media> bdd;

	public Mediatheque(){
		bdd = new ArrayList<Media>();
	}

	public void ajouter(Media m){
		if(bdd.isEmpty()){bdd.add(m); return;}
		for(int i = 0; i<bdd.size(); i++){
			if(bdd.get(i).plusPetit(m)){
				bdd.add(i, m);
				break;
			}
		}
	}

	public String toString(){
		String acc = "";
		for(int i = 0; i < bdd.size(); i++){
			acc = bdd.get(i).toString() + "\n\n" + acc;
		}
		return acc;
	}

	public void tousLesLivres(){
		for(int i = 0; i < bdd.size(); i++){
			if(bdd.get(i) instanceof Livre)
				System.out.println(bdd.get(i) + "\n");
		}
	}

	public ArrayList<Media> recherche(Predicat p){
		ArrayList<Media> acc = new ArrayList<>();
		for(Media m: bdd){
			if(p.estVrai(m))
				acc.add(m);
		}
		return acc;
	}
}
