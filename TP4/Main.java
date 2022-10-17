import java.util.ArrayList;

class Main{
	public static void main(String[] args){
		Mediatheque mt = new Mediatheque();
		Livre l1 = new Livre("S1", "AL1", 10);
		Video v1 = new Video("V1", 1);
		Manga m1 = new Manga("M", "v", 100, "f", true);
		Manga m2 = new Manga("Mfe", "v", 100, "f", true);
		mt.ajouter(l1);
		mt.ajouter(v1);
		mt.ajouter(m1);
		mt.ajouter(m2);
		System.out.println(mt);
		System.out.println("----------");
		mt.tousLesLivres();
		System.out.println("----------");
		ArrayList<Media> sub;
		sub = mt.recherche(new Et(new EstUnLivre(), new TitreCommencePar('S')));
	
		for(Media m : sub){
			System.out.println(m.getTitre());
		}
	}
}
