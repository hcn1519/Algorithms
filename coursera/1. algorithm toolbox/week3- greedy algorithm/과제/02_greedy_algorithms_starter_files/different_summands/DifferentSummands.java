import java.util.*;

public class DifferentSummands {
    // n이 1부터 몇까지의 합인지 리턴하는 함수
    private static int getLength(int n){
      int sum = n;
      int length = 0;
      for(int i=1; i<=n; i++){
        sum -= i;
        if(sum<0) break;
        length++;
      }
      return length;
    }
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        if(n==1){
          summands.add(1);
          return summands;
        } else if(n ==2){
          summands.add(2);
          return summands;
        }

        int length = getLength(n);
        int k=1;
        int i=0;
        while(i < length){
          if(n-k >= k+1){ // 10-1 > 1+1, 9-2 > 2+1, 7-3 >
            summands.add(k);
            n -= k;
            k++;
          } else{
            summands.add(n);
            break;
          }
          i++;
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }

    }
}
