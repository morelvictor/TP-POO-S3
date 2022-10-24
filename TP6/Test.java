class Test{
	public static void main(String[] args){
		String[] d = {"a", "b", "d", "c", "e"};
		Dictionnaire t = new Dictionnaire(d);
		System.out.println(t);
		Triable.triBulles(t);
		System.out.println(t);
	}
}
