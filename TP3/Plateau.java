class Plateau{
	int width;
	int height;
	Case[][] cases;

	public Plateau(int w, int h){
		width = w;
		height = h;
		Case[][] acc = new Case[w][h];
		for(int y = 0; y < acc.length; y++){
			for(int x = 0; x < acc[y].length; x++){
				if((y+x)%2 == 0){
					acc[y][x] = new Case(false, null);
				}else{
					acc[y][x] = new Case(true, null);
				}
			}
		}
		cases = acc;
	}

	public boolean outside(int x, int y){
		return x < 0 || y < 0 || x >= width || y >= height;
	}

	public boolean outside(Deplacement d){
		return (d.x0 < 0 || d.y0 < 0 || d.x0 >= width || d.y0 >= height) && (d.x1 < 0 || d.y1 < 0 || d.x1 >= width || d.y1 >= height);
	}

	public Case getCase(int x, int y){
		if(!outside(x, y))
			return cases[y][x];
		return null;
	}
	
	public void removePiece(int x, int y){
		if(!outside(x, y))
			cases[y][x].removePiece();
	}

	public void placePiece(int x, int y, Piece p){
		if(!outside(x, y))
			cases[y][x].placePiece(p);
	}

	public void print(){
		for(int y = 0; y < cases.length; y++){
			for(int x = 0; x < cases[y].length; x++){
				System.out.print(cases[y][x]);
			}
			System.out.print("\n");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~");
	}
	
}












