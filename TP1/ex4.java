import java.util.Scanner;

class Ex4{
  
  public static int question(int maxTentatives){
    int n1 = (int) (Math.random() * 10);
    int n2 = (int) (Math.random() * 10);
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < maxTentatives; i++){
      System.out.println(n1 + "*" + n2);
      if(sc.nextInt() == n1*n2){
        return i;
      }
    }
    return maxTentatives;
  }

  public static int evaluation(int n){
    int note = n;
    for(int i = 0; i<n; i++){
      note -= question(1);
    }
    return note;
  }

  public static void main(String[] args){
    System.out.println(evaluation(3));
    

  }
}
