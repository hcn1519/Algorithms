import java.util.*;

class EditDistance {
  public static int min(int x, int y, int z){
    int min = x;
    if(min > y)
      min = y;
    if(min > z)
      min = z;

    return min;
  }
  public static int EditDistance(String s, String t) {
    int n = s.length();
    int m = t.length();
    int D[][] = new int[n+1][m+1];

    for(int i=0; i<D.length; i++){
      for(int j=0; j< D[i].length; j++){
        if(i == 0){
          D[i][j] = j;
        } else if(j == 0){
          D[i][j] = i;
        } else {
          if(s.charAt(i-1) == t.charAt(j-1)){
            D[i][j] = min(D[i][j-1]+1, D[i-1][j]+1, D[i-1][j-1]);
          } else {
            D[i][j] = min(D[i][j-1]+1, D[i-1][j]+1, D[i-1][j-1]+1);
          }
        }
      }
    }

    // for(int i=0; i<D.length; i++){
    //   for(int j=0; j< D[i].length; j++){
    //     System.out.print(D[i][j]+ " ");
    //   }
    //   System.out.println();
    // }
    return D[n][m];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
