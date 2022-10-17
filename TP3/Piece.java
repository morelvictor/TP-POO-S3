class Piece{
	boolean color;
	String type;
	boolean moved = false;

	public Piece(boolean c, String t){
		color = c;
		type = t;
	}

	public String toString(){
		if(!color) 
			return Character.toUpperCase(type.charAt(0)) + type.substring(1);
		return Character.toLowerCase(type.charAt(0)) + type.substring(1);
	}

	public String getType(){ return type; }

	public boolean estValide(Deplacement d, Plateau p){
		if(p.outside(d))
			return false;
		if(p.getCase(d.x1, d.y1).piece != null){
			if(p.getCase(d.x1, d.y1).piece.color == color)
				return false;
		}
		if(p.getCase(d.x1, d.y1).piece != this)
			return false;
		return true;
	}
}
