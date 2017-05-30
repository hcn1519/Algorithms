import java.util.*;

public class BOJ_2749 {

  private static BigInteger fastFiboLastDigit(int n){
      if(n<= 1) return n;
      BigInteger lastDigit[] = new BigInteger[n+1];

      lastDigit[0] = 0;
      lastDigit[1] = 1;
      for(int i=2; i< lastDigit.length; i++)
        lastDigit[i] = lastDigit[i-1]%1000000 + lastDigit[i-2]%1000000;
      lastDigit[n] = lastDigit[n]%1000000;
      return lastDigit[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = fastFiboLastDigit(n);
        System.out.println(d);

    }
}
