import java.util.*;

public class BOJ_11051 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    int n = scin.nextInt();
    int r = scin.nextInt();

    System.out.println(getCombination(n, r));
  }

  static int getCombination(int n, int r) {
    int combination[][] = new int[n+1][r+1];

    for(int i=1; i<=n; i++){

      for(int k=0; k<=min(i, r); k++){
        if (k == 0 || k == i) {
          combination[i][k] = 1;
        } else {
          combination[i][k] = (combination[i-1][k-1] + combination[i-1][k]) % 10007;
        }
      }

    }
    return combination[n][r];
  }

  static int min(int n, int k){
    return (n > k ? k : n);
  }
}
