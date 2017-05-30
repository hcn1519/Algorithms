/**
 * Created by changnam on 2017. 5. 29..
 */
import java.util.*;

public class BOJ_4948 {
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);

        int primeCheck[] = getPrimeSet(123456*2+1);

        while (true){
          int n = scin.nextInt();

          if (n == 0){
            break;
          }
          int counter = 0;
          for(int i=n; i<=2*n; i++){
            if (primeCheck[i] != 0) {
              counter++;
            }
          }
          System.out.println(counter);

        }

    }

    static int[] getPrimeSet(int range) {
        int result[] = new int[range];

        for(int i=2; i<result.length; i++){
            result[i] = i;
        }

        for(int i=2; i<result.length; i++){
            if (result[i] == 0)
                continue;

            for(int k = i+i; k<result.length; k+=i) {
                result[k] = 0;
            }
        }

        return result;
    }
}
