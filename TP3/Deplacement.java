class Deplacement{
	int x0, y0, x1, y1;
	
	public Deplacement(int x0, int y0, int x1, int y1){
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	public char typeDeplacement(){
		if(Math.abs(x1-x0) == Math.abs(y1-y0)) return 'd';
		if(Math.abs(x1-x0) != 0 && y1 == y0) return 'h';
		if(x0 == x1 && Math.abs(y1-y0) != 0) return 'v';
		if((Math.abs(x0-x1) == 2 && Math.abs(y0-y1) == 1) || (Math.abs(x0-x1) == 1 && Math.abs(y0-y1) == 2)) return 'c';
		return 'x';
	}

	public int dist(){
		switch(typeDeplacement()){
			case 'd':
				return Math.abs(x1-x0);
			case 'h':
				return Math.abs(x1-x0);
			case 'v':
				return Math.abs(y1-y0);
			default:
				return -1;
		}
	}

	public boolean pieceEntre(Plateau p){
		if(typeDeplacement() == 'v'){
			for(int y = y0; Math.abs(y-y1) > 0; y+=(Math.abs(y1-y0)/(y1-y0))){
				if(p.getCase(x0, y).piece != null) return true;
			}
		}
		if(typeDeplacement() == 'h'){
			for(int x = x0; Math.abs(x - x1) > 0; x+=(Math.abs(x1-x0)/(x1-x0))){
				if(p.getCase(x, y0).piece != null) return true;
			}
		}
		if(typeDeplacement() == 'd'){
			for(int y = y0; Math.abs(y-y1) > 0; y+=(Math.abs(y1-y0)/(y1-y0))){
				for(int x = x0; Math.abs(x - x1) > 0; x+=(Math.abs(x1-x0)/(x1-x0))){
					if(p.getCase(x, y).piece != null) return true;
				}
			}
		}
		return false;
	}

}
