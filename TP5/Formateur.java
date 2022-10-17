import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

class Formateur{
	LinkedList<Paragraphe> texte;
	Scanner sc;
	
	private Paragraphe readParagraphe(){
		Paragraphe acc = new Paragraphe();
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			Ligne ligne = new Ligne();
			Scanner sc2 = new Scanner(sc.next());
			while(sc2.hasNext()){
				ligne.addChaine(new ChaineCar(sc2.next()));
			}
			acc.addLigne(ligne);
		}
		sc.useDelimiter(Pattern.compile("\\s"));
		return acc;
	}

	public void read(){
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
		}
		catch(Exception e){
			System.out.println("Erreur lors de l'ouverture du fichier:");
			e.printStackTrace();
			System.exit(1);
		}
		texte = new LinkedList<Paragraphe>();
	}
}
