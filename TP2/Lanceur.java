import java.util.Scanner;

class Lanceur{
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Voulez-vous jouer une partie (y/n)");
			char answer = scanner.next().charAt(0);
			if(answer == 'y'){
				menu();
			}else if(answer == 'n'){
				return;
			}
		}
	}

	public static void menu(){
		
	}
}
