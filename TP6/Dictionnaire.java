class Dictionnaire implements Triable{
	String[] tab;
	
	public Dictionnaire(String[] t){
		tab = t;
	}

	public void echange(int i, int j){
		String tmp = tab[j];
		tab[j] = tab[i];
		tab[i] = tmp;
	}

	public boolean plusGrand(int i, int j){
		return tab[i].compareTo(tab[j]) > 0;
	}

	public int taille(){
		return tab.length;
	}

	public String toString(){
		if(tab.length == 0) return "{}";
		String s = "{";
		for(int i = 0; i < tab.length -1; i++){
			s += tab[i] + ", ";
		}
		s += tab[tab.length - 1] + "}";
		return s;
	}
}
