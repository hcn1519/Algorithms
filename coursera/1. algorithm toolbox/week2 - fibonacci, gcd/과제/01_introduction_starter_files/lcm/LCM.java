import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.math.BigInteger;

public class LCM {
  private static long lcm_naive(long a, long b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return a * b;
  }
  private static long gcd_fast(long a, long b){
    if(a>= b){
      if(a%b ==0) return b;
      else
        return gcd_fast(b, a%b);
    } else {
      if(b%a ==0) return a;
      else return gcd_fast(a, b%a);
    }
  }
  private static long lcm_fast(long a, long b){
    long result = a*b;
    long x = gcd_fast(a, b);
    return (result/x);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    // System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a,b));
    // while(true){
    //   long a = ThreadLocalRandom.current().nextLong(1, 2000000000);
    //   long b = ThreadLocalRandom.current().nextLong(1, 2000000000);
    //
    //   long res1 = lcm_naive(a,b);
    //   long res2 = lcm_fast(a,b);
    //   System.out.println("(" +a + ", "+ b + ") " + res2);
    //   if(res1 == res2){
    //     System.out.println("input (" + a +", " + b +")" + " OK (" + res1 +", " + res2 +")");
    //   } else{
    //     System.out.println("input (" + a +", " + b +")" + " Wrong (" + res1 +", " + res2 +")");
    //     break;
    //   }
    // }
  }
}
