import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] weights) {
        int value[][] = new int[weights.length+1][W+1];
        int v[] = new int[weights.length];
        for(int i=0; i< v.length; i++)
          v[i] = weights[i];

        for(int i=1; i<weights.length+1; i++){
          for(int w=1; w<W+1; w++){
              value[i][w] = value[i-1][w];
              if(weights[i-1] <= w){
                  int val = value[i-1][w - weights[i-1]] + v[i-1];
                  if(value[i][w] < val && val <= w){
                    value[i][w] = val;
                  }
              }

          }
        }

        // 출력 결과 테스트용
        // for(int i=0; i< value.length; i++){
        //   for(int k=0; k< value[i].length; k++){
        //     System.out.print(value[i][k] + " ");
        //   }
        //   System.out.println();
        // }

        return value[weights.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
