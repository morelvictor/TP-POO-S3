class TriBinaire extends TabEntiersTriable{
	public TriBinaire(int[] t){
		super(t);
	}

	public String toString(){
		if(tab.length == 0) return "{}";
		String s = "{";
		for(int i = 0; i < tab.length -1; i++){
			s += Integer.toString(tab[i], 2) + ", ";
		}
		s += Integer.toString(tab[tab.length - 1], 2) + "}";
		return s;
		
	}
}
