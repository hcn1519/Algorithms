import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

        double perValue[] = new double[values.length];
        int priority[] = new int[values.length];
        for(int i=0; i<perValue.length; i++){
          perValue[i]= (double)values[i]/(double)weights[i];
          priority[i] = i;
        }
        double temp = 0.0;
        int temp2=0;
        // System.out.println(Arrays.toString(perValue));
        // System.out.println(Arrays.toString(priority));
        for(int i=0; i<perValue.length; i++){
          for(int j=i; j<perValue.length; j++){
            if(perValue[i]<perValue[j]){
              temp = perValue[i];
              perValue[i] = perValue[j];
              perValue[j] = temp;

              temp2 = priority[i];
              priority[i] = priority[j];
              priority[j] = temp2;
            }
          }
        }
        // System.out.println(Arrays.toString(perValue));
        // System.out.println(Arrays.toString(priority));

        // 우선순위의 숫자가 큰 것이 먼저 실행되도록 설정
        for(int i=0; i<values.length; i++){
            if(weights[priority[i]] <= capacity){
              value += (double)perValue[i]*weights[priority[i]];
              capacity -= weights[priority[i]];
              // System.out.println("perValue[i] : " + perValue[i]);
              // System.out.println("perValue[i]*weights[priority[i]] : " + perValue[i]*weights[priority[i]]);
              // System.out.println("value1 : " + value);
              // System.out.println("capa : " + capacity);
            } else if(weights[priority[i]] > capacity){
              value += (double)(perValue[i]*capacity);
              capacity = 0;
              // System.out.println("perValue[i] : " + perValue[i]);
              // System.out.println("perValue[i]*weights[priority[i]] : " + perValue[i]*weights[priority[i]]);
              // System.out.println("value2 : " + value);
              // System.out.println("capa : " + capacity);
            }
          // System.out.println("=============");
          // System.out.println("index : " + i);
          if(capacity <0) break;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double result = getOptimalValue(capacity, values, weights);
        System.out.println(Math.round(result * 10000.0) / 10000.0);
    }
}
