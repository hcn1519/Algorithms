import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  private static int gcd_fast(int a, int b){
      if(a==1 || b==1 ) return 1;

      if(a==0){
        // System.out.println("return b : " + b);
         return b;
      } else if(b==0){
        // System.out.println("return a : " + a);
         return a;
      }
      if(a == b){
        // System.out.println("Same " + a);
        return a;
      } else if(a> b){
        // System.out.println("call a-b : " + a +", "+ b);
        return gcd_fast(a-b, b);
      } else {
        // System.out.println("call b-a : " + b +", "+ a);
        return gcd_fast(b-a, a);
      }
  }
  private static int gcd_another(int a, int b){
    if(a>= b){
      if(a%b ==0) return b;
      else
        return gcd_another(b, a%b);
    } else {
      if(b%a ==0) return a;
      else return gcd_another(a, b%a);
    }
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(gcd_naive(a, b));
    System.out.println(gcd_fast(a, b));
    System.out.println(gcd_another(a, b));
    // while(true){
    //   Random rand = new Random();
    //   int a = rand.nextInt(1000000);
    //   int b = rand.nextInt(1000000);
    //
    //   int res1 = gcd_naive(a,b);
    //   int res2 = gcd_fast(a,b);
    //
    //   if(res1 == res2){
    //     System.out.println("input (" + a +", " + b +")" + " OK (" + res1 +", " + res2 +")");
    //   } else{
    //     System.out.println("input (" + a +", " + b +")" + " Wrong (" + res1 +", " + res2 +")");
    //     break;
    //   }
    // }
  }
}
