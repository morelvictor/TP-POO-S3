class TabEntiersTriable implements Triable{
	int[] tab;

	public void echange(int i, int j){
		int tmp = tab[j];
		tab[j] = tab[i];
		tab[i] = tmp;
	}

	public boolean plusGrand(int i, int j){
		return tab[i] >= tab[j];
	}

	public int taille(){
		return tab.length;
	}

	public TabEntiersTriable(int[] t){
		tab = t;
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
