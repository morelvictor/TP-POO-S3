class Test{
	public static void main(String[] args){
		Formateur f = new Formateur("texte");
		if(args.length > 0){
			f = new Formateur(args[0]);
		}

		f.read();
		f.print();
	}
}
