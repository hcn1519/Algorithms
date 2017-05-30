/**
 * Created by changnam on 2017. 5. 29..
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1978 {
    public static void main(String[] args) {
        Scanner scin = new Scanner(System.in);

        int number = scin.nextInt();

        int primeCheck[] = new int[1000];

        for(int i=2; i<primeCheck.length; i++){
            primeCheck[i] = i;
        }

        for(int i=2; i<primeCheck.length; i++){
            if (primeCheck[i] == 0){
                continue;
            }
            for(int k = i+i; k<primeCheck.length; k+=i) {
                primeCheck[k] = 0;
            }
        }

        int result = 0;
        for(int i=0; i<number; i++){
            int num = scin.nextInt();

            if (primeCheck[num] != 0) {
                result++;
            }
        }

        System.out.println(result);

    }
}
