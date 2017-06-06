import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private int parent(int i) {
      return i/2;
    }
    private int child(int i, Boolean isLeft) {
      return (isLeft ? i*2 : i*2+1);
    }

    private Boolean hasRightChild(int i) {
      return (i*2+1 <= data.length ? true : false);
    }

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();

      // TODO: 힙정렬로 만들기

      int size = data.length;

      for(int i=size/2; i>0; i--) {

        int maxIndex = i;
        while(maxIndex*2 <= size) {
          int j = maxIndex;
          if (hasRightChild(maxIndex)) {
            // 자리 옮김 여부 체크
            if (data[maxIndex-1] > data[child(maxIndex, true)-1] || data[maxIndex-1] > data[child(maxIndex, false)-1])  {
              // 작은 쪽 선택
              if (data[child(maxIndex, true)-1] < data[child(maxIndex, false)-1]) {
                  maxIndex = child(maxIndex, true);
              } else {
                  maxIndex = child(maxIndex, false);
              }
            }
          } else {
            // 자리 옮김 여부 체크
              if (data[maxIndex-1] > data[child(maxIndex, true)-1]) {
                maxIndex = child(maxIndex, true);
              }
          }

          if (maxIndex != j) {
              swaps.add(new Swap(j-1, maxIndex-1));
              int tmp = data[maxIndex-1];
              data[maxIndex-1] = data[j-1];
              data[j-1] = tmp;
          } else {
            break;
          }
        }
      }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
