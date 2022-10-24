
import java.util.Scanner;
import java.util.regex.Pattern;

class FormateurJoli extends Formateur{
	int maxLength;
	
	public FormateurJoli(String filename, int ml){
		super(filename);
		this.maxLength = ml;
	}

	public Paragraphe readParagraphe(){
		ParagrapheJoli p = new ParagrapheJoli(maxLength);
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
}
