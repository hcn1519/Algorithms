import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class MajorityElement {
    private static int[] merge(int a, int b, int []list){
      int countA=0;
      int countB=0;
      int result[] = new int[1];

      for(int i=0; i< list.length; i++){
        if(list[i] == a)
          countA++;
        if(list[i] == b)
          countB++;
      }
      if(countA > list.length/2){
        result[0] = a;
      } else if(countB > list.length/2){
        result[0] = b;
      } else {
        return list;
      }
      return result;

    }
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left + 1 == right || left == right) {
            return a[left];
        }
        // System.out.println(Arrays.toString(a));


        int mid = (left + right - 1)/2; // 0, 5 -> 2  0, 4 -> 2    0, 6 -> 3

        int front[] = new int[mid+1]; // 3
        for(int i=0; i<front.length; i++)
          front[i] = a[i];

        // System.out.println(Arrays.toString(a));
        // System.out.print("left : " + left + ", ");
        // System.out.print("right : " + right + ", ");
        // System.out.println("mid : " + mid);

        int back[] = new int[right - mid -1]; // 5-2-1 = 2
        for(int i=0; i<back.length; i++)
          back[i] = a[mid + 1 + i];

        int sub1 = getMajorityElement(front, left, mid+1);
        // System.out.println("sub1 : " + sub1);


        int sub2 = getMajorityElement(back, left, mid);
        // System.out.println("sub2 : " + sub2);

        int result[] = merge(sub1, sub2, a);
        // System.out.println("result >>>");
        // System.out.println(Arrays.toString(result));

        if(result.length == 1)
          return result[0];
        else
          return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        // while(true){
        //   int n = ThreadLocalRandom.current().nextInt(1, 100);
        //   int[] a = new int[n];
        //   for(int i=0; i< n; i++){
        //     a[i] = ThreadLocalRandom.current().nextInt(0, 100);
        //   }
        //   if (getMajorityElement(a, 0, a.length) != -1) {
        //       System.out.println(1);
        //   } else {
        //       System.out.println(0);
        //   }
        // }

    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
