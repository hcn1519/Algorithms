import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x, int left, int right) {

        int mid = (right-left)/2 + left; // mid = 2
        // 없는 경우
        if (right < left || mid >= a.length) return -1;

        // System.out.println("left : " + left);
        // System.out.println("right : " + right);
        // System.out.println("mid : " + mid);
        if(x == a[mid]) { // 최종 결과
          // System.out.println("answer : " + mid);
          return mid;
        } else if(x < a[mid]){ // 값이 mid보다 작은 경우
          // int arr[] = new int[mid];
          // for(int i=0; i<mid; i++)
          //   arr[i] = a[i];
          // System.out.println("upper");
          // System.out.println(Arrays.toString(a));
          // System.out.println(Arrays.toString(arr));
          return binarySearch(a, x, left, mid-1);
        } else{ // 값이 mid보다 큰 경우
          // int arr[] = new int[mid];
          // for(int i=0; i<mid; i++)
          //   arr[i] = a[mid + (i+1)];
          // System.out.println("down");
          // System.out.println(Arrays.toString(a));
          // System.out.println(Arrays.toString(arr));
          return binarySearch(a, x, mid+1, right);
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            // System.out.print(linearSearch(a, b[i]) + " ");
            // System.out.println("시작 b[i] : " + b[i]);
            System.out.print(binarySearch(a, b[i], 0, a.length) + " ");
        }
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
