import java.util.*;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  private static long fast_fib(int n) {
    if(n <=1) return n;
    long []Fibo = new long[n+1];
    Fibo[0] = 0;
    Fibo[1] = 1;

    for(int i=2; i<Fibo.length; i++)
      Fibo[i] = Fibo[i-1] + Fibo[i-2];
    return Fibo[n];
  }
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(fast_fib(n));

    // for Stress Testing
    // while(true){
    //     Random rand = new Random();
    //     int n = rand.nextInt(45);
    //
    //     long res1 = calc_fib(n);
    //     long res2 = fast_fib(n);
    //     if(res1 == res2){
    //         System.out.println("OK, result : " + res2);
    //     } else {
    //       System.out.println("wrong answer : " + res1+ ", " + res2);
    //       break;
    //     }
    //
    // }

  }
}
