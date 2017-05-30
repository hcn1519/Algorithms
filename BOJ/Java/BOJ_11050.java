import java.util.*;

public class BOJ_11050 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);

    int n = scin.nextInt();
    int r = scin.nextInt();

    int result = factorial(n)/(factorial(r)*factorial(n-r));

    System.out.println(result);
  }

  static int factorial(int n) {
    int result = 1;
    for(int i=1; i<=n; i++)
      result *= i;

    return result;
  }
}
