
class Ex2{  
  public static void affiche(int t[]){
    for(int i : t){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static int[] multiplication(int t1[], int t2[]){
    int acc[] = new int[Math.max(t1.length, t2.length)];
    for(int i = 0; i < acc.length; i++){
      if(i < t1.length && i < t2.length){
        acc[i] = t1[i] * t2[i];
      }else if(i>=t1.length){
        acc[i] = t2[i];
      }else{
        acc[i] = t1[i];
      }
    }

    return acc;
  }

  public static int[] split(int t[]){
    String acc = "";
    for(int i : t){
      acc += String.valueOf(i);
    }

    int[] r = new int[acc.length()];
    for(int i = 0; i < r.length; i++){
      r[i] = acc.charAt(i) - '0';
    }
    return r;
  }

  public static void main(String[] args){
    int[] n = {1, 2, 3, 1, 10};
    int[] m = {4, 5, 6, 23};
    affiche(multiplication(n, m));
    int[] s = {12, 34, 56, 7};
    affiche(split(s));
    
  }
}
