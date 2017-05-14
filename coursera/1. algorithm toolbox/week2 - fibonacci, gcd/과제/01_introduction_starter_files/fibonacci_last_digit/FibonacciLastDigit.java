import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static int fastFiboLastDigit(int n){
      if(n<= 1) return n;
      int lastDigit[] = new int[n+1];

      lastDigit[0] = 0;
      lastDigit[1] = 1;
      for(int i=2; i< lastDigit.length; i++)
        lastDigit[i] = lastDigit[i-1]%10 + lastDigit[i-2]%10;
      lastDigit[n] = lastDigit[n]%10;  
      return lastDigit[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = fastFiboLastDigit(n);
        System.out.println(d);

    }
}
