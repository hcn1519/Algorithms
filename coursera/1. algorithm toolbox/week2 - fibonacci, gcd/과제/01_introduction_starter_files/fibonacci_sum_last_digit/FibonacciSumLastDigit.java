import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    private static long sumOfLastDigit(long n){
      if(n<= 1) return n;

      long prev = 0;
      long current = 1;
      long sum = 1;
      long temp;
      for(int i=2; i< n+1; i++){
        temp = current;
        current += prev;
        current %= 10;
        prev = temp;
        sum += current;
        sum %= 10;
      }
      return sum;
    }
    private static long HugeSumOfLastFiboDigt(long n){
      if(n<= 1) return n;
      // 피보나치의 마지막 자릿수들의 합은 60을 주기로 돌아간다.
      // 그런데 60을 주기로 합의 나머지가 항상 0이므로, 60의 나머지만 계산하면 모든 숫자를 계산할 수 있다.
      long result= sumOfLastDigit(n%60);

      return result;
    }
    // f0, f1, f2, f3, f4, f5, f6, f7, f8, f9
    //  0,  1,  1,  2,  3,  5,  8, 3, 1, 4, 5, 9, 4, 3, 7, 0, 7, 7, 4, 1, 5, 6, 1, 7, 8, 5
    //  0,  1,  2,  4,  7,  2,  0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7


    //  0,  1,  2,  4,  7, 12, 20, 33, 54, 88, 143, 232, 376, 609, 986, 1596, 2583, 0, 4, 5, 9
    //  0,  1,  2,  4,  7,  2,  0,  3,  4,  8,   3,   2,   6,   9,   6,    6,    3

    // 1 2 4 7 2
    // 3 4 8 3 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // long s = getFibonacciSumNaive(n);
        System.out.println(HugeSumOfLastFiboDigt(n));



        // while(true){
        //   long a = ThreadLocalRandom.current().nextLong(1, 100);
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
