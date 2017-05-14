import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    private static long fastFiboLastDigit(long k){
      if(k<= 1) return k;
      int n = (int)k;
      int lastDigit[] = new int[n+1];

      lastDigit[0] = 0;
      lastDigit[1] = 1;
      for(int i=2; i< lastDigit.length; i++)
        lastDigit[i] = lastDigit[i-1]%10 + lastDigit[i-2]%10;
      lastDigit[n] = lastDigit[n]%10;
      return (long)lastDigit[n];
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
    private static long sumOfLastDigitReal(long n){
      if(n<= 1) return n;

      long sum = 1;

      for(int i=2; i<n+1; i++)
        sum += fastFiboLastDigit(i);
      return sum;
    }
    private static long PartialSumFast(long m, long n){
      if(n<= 1) return n;
      // 피보나치의 마지막 자릿수들의 합은 60을 주기로 돌아간다.
      // 그런데 60을 주기로 합의 나머지가 항상 0이므로, 60의 나머지만 계산하면 모든 숫자를 계산할 수 있다.
      long start = m%60;
      long end = n%60;
      long result =0;
      // 합산을 해서 10으로 나눈 값이 sumOfLastDigit이다 보니 결과값이 틀림
      if(start == 0){
        return sumOfLastDigit(end);
      } else if(end == 0){
        return sumOfLastDigit(start);
      } else {
        if(start < end){
          result = (sumOfLastDigitReal(end) - sumOfLastDigitReal(start-1))%10;
          return result;
        } else if(start > end){
          result = (sumOfLastDigitReal(60) - sumOfLastDigitReal(end-1) + sumOfLastDigitReal(start))%10;
          return result;
        } else{
          return fastFiboLastDigit(start);
        }
      }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        // System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(PartialSumFast(from, to));
        // System.out.println(sumOfLastDigitReal(from));
    }
}
