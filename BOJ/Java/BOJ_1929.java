/**
 * Created by changnam on 2017. 5. 29..
 */
import java.util.*;

public class BOJ_1929 {
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);

        int minNum = scin.nextInt();
        int maxNum = scin.nextInt();

        int primeCheck[] = getPrimeSet(1000000+1);

        for(int i=minNum; i<=maxNum; i++){
          if(primeCheck[i] != 0)
            System.out.println(primeCheck[i]);
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
