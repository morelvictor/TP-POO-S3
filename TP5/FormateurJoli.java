
import java.util.Scanner;
import java.util.regex.Pattern;

class FormateurJoli extends Formateur{
	int maxLength;
	
	public FormateurJoli(String filename, int ml){
		super(filename);
		this.maxLength = ml;
	}

	public Paragraphe readParagraphe(){
		System.out.println("Tu es bourré Victor");
		ParagrapheJoli acc = new ParagrapheJoli(maxLength);
		acc.addChaine(new Espace(4));
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			Scanner sc2 = new Scanner(sc.next());
			while(sc2.hasNext()){
				acc.addChaine(new ChaineCar(sc2.next()));
			}
			acc.addLigne(new Ligne());
		}
		sc.useDelimiter(Pattern.compile("\\s"));
		return acc;
	}

	public void read(){
		while(sc.hasNext()){
			texte.add(readParagraphe());
		}
	}
}
