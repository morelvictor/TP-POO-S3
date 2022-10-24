import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

class Formateur{
	LinkedList<Paragraphe> texte;
	Scanner sc;
	
	private Paragraphe readParagraphe(){
		Paragraphe p = new Paragraphe();
		String para = sc.next();
		Scanner s = new Scanner(para);
		while(s.hasNext()){
			p.addChaine(new ChaineCar(s.next()));
			p.addChaine(new Espace());
		}
		return p;
	}

	public void read(){
		sc.useDelimiter("\n\\s*\n");
		while(sc.hasNext()){
			texte.add(readParagraphe());
		}
	}

	public void print(){
		for(Paragraphe p : texte){
			System.out.println(p);
			if(p != texte.getLast())
				System.out.print("\n");
		}
	}

	public Formateur(String filename){
		sc = null;
		try{
			sc = new Scanner(new File(filename));
			sc.useDelimiter("\n\n");
		}
		catch(Exception e){
			System.out.println("Erreur lors de l'ouverture du fichier:");
			e.printStackTrace();
			System.exit(1);
		}
		texte = new LinkedList<Paragraphe>();
	}
}
