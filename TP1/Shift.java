class Shift{
  
  public static int check(char[] t, char c){
    for(int i = 0; i<t.length; i++){
      if(t[i] == c)
        return i;
    }
    return -1;
  }

  public static void main(String[] args){
    char[] voy = {'y', 'u', 'o', 'i', 'e', 'a'};
    String acc = "";

    for(String s : args){
      for(int i = 0; i<s.length(); i++){
         int n = check(voy, s.charAt(i));
         if (n == -1){
           acc += s.charAt(i);
         }else{
          acc += voy[(n+1)%6];
         }
      }
      acc += " ";
    }
  System.out.println(acc);
  }
}
