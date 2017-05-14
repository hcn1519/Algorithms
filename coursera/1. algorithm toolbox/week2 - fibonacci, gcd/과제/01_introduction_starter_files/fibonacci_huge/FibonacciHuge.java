import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
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
    private static long FiboHugeFast(long n, long m){
      if(n<= 1) return n;

      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(1);

      int prev=1;
      int current=1;
      int temp, temp2;
      int length = 2;
      while(true){
        temp = current;  // 1, 2
        current += prev; // 2, 3
        current %= m;
        prev = temp;     // 1, 2
        prev %= m;

        if(prev == 0 && current == 1){
          int flag = 2;
          for(int i=2; i<length; i++){
            // prev = 0, current = 1
            temp2 = current;
            current += prev;
            current %= m;
            prev = temp2;
            prev %= m;
            temp2 = list.get(i);
            // System.out.println("current : " + current + " temp2 : " + temp2);
            // System.out.println("Current List is >>>");
            // System.out.println(list);
            if(current == temp2) flag++;
            else break;
          }
          if(flag == length){
            break;
          } else {
            // need initialize
            System.out.println("It's not cycle");
          }
        }
        list.add(prev);
        length++;
      }
      // System.out.println("length : " + length);
      // System.out.println("cycle >>>");
      // System.out.println(list);

      int index = (int)(n%length);
      int result = list.get(index);
      // System.out.println("length : " + length);
      // System.out.println("index : " + index);
      // System.out.println("result : " + result);
      return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        // System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(FiboHugeFast(n, m));
    }
}
