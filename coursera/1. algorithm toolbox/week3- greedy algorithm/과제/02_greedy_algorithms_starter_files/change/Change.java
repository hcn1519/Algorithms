import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int partition = 0;

        while(m>0){
          if(m/10 != 0){
            partition += (m/10);
            m -= (m/10)*10;
          } else if(m/5 != 0) {
            partition += (m/5);
            m -= (m/5)*5;
          } else {
            partition += m;
            m -= m;
          }
        }
        return partition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        // while(true){
        //   int m = ThreadLocalRandom.current().nextInt(1, 1000);
        //
        //   int res = getChange(m);
        //   System.out.println("yes + " + res);
        // }
    }
}
