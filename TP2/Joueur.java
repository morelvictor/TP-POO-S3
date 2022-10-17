import java.util.Scanner;

class Joueur{
	private String nom;
	Scanner scanReponse;

	public Joueur(){
		nom = "Anonyme";
		scanReponse = new Scanner(System.in);
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public void finir(){
		scanReponse.close();
	}

	public boolean veutJouer(){
		System.out.println("Voulez vous jouer (oui/non) ?");
		String ans = scanReponse.next();
		if(ans.equals("oui")){
			return true;
		}
		if(ans.equals("non")){
			finir();
			return false;
		}
		return veutJouer();
	}

	public String demanderNom(){
		System.out.println("Quel est votre nom?");
		return scanReponse.next();
	}

	public int[] demanderDimensions(){
		int[] acc = new int[2];
		System.out.println("Entrez la largeur");
		acc[0] = scanReponse.nextInt();
		System.out.println("Entrez la hauteur");
		acc[1] = scanReponse.nextInt();
		return acc;
	}

	public int demanderNbMines(){
		System.out.println("Combien de mines voulez vous?");
		return scanReponse.nextInt();
	}

	public char demanderAction(){
		System.out.println("Voulez-vous reveler une case (r) ou placer un drapeau (d) ?");
		char choice = scanReponse.next().charAt(0);
		if (choice == 'r' || choice == 'd')
			return choice;
		return demanderAction();
	}

	public int[] demanderCoordonnes(){
		int[] acc = new int[2];
		System.out.println("Entrez les coordonnées");
		String rep = scanReponse.next();
		acc[0] = rep.charAt(1) - '0' + 1;
		acc[1] = rep.charAt(0) - 'a' + 1;
		return acc;
	}
}




















