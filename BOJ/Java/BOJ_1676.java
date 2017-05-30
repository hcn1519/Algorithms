import java.util.*;

public class BOJ_1676 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);

    int n = scin.nextInt();

    System.out.println(factorial(n));

  }
  static int factorial(int n) {
    int result = 0;

    for(int i=1; i<=n; i++) {
        if (i%5 == 0){
          result++;
        }

        if (i % 25 == 0) {
          result++;
        }

        if (i % 125 == 0) {
          result++;
        }
    }

    return result;
  }
}
