import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    private static ArrayList<Integer> dynamic_solution(int n){
      ArrayList<Integer> sequence = new ArrayList<Integer>();
      int d[] = new int[n+1];
      d[1] = 0;
      for(int i=2; i<=n; i++){
        d[i] = d[i-1] + 1;
        if(i%2 == 0 && d[i] > d[i/2] + 1){
          d[i] = d[i/2] + 1;
        }
        if(i%3 == 0 && d[i] > d[i/3] + 1){
          d[i] = d[i/3] + 1;
        }
      }

      int count = d[n];
    	int j = n;
    	int verify = n;
    	sequence.add(n);
    	while (j >= 1) {
    		if (d[j] == (count - 1)) {
    			if (verify % j == 0 || verify - 1 == j) {
    				verify = j;
    				count--;
    				sequence.add(j);
    			}
    		}
    		j--;
    	}
      Collections.reverse(sequence);
      return sequence;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> sequence = dynamic_solution(n);
        System.out.println(sequence.size()-1);
        for (int x : sequence) {
            System.out.print(x + " ");
        }

    }
}
