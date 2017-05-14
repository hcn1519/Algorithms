import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
  		StringTokenizer tok = new StringTokenizer("");
  		BufferedReader in;

  		FastScanner() {
  			in = new BufferedReader(new InputStreamReader(System.in));
  		}

  		String next() throws IOException {
  			while (!tok.hasMoreElements())
  				tok = new StringTokenizer(in.readLine());
  			return tok.nextToken();
  		}
  		int nextInt() throws IOException {
  			return Integer.parseInt(next());
  		}
	}

  class Node {
    int n;
    ArrayList<Node> childNodes;
    Node(){}

    Node(int n){
      this.n = n;
      this.childNodes = new ArrayList<Node>();
    }

  }
	public class TreeHeight {
		int n;
		int parent[];
    Node nodes[];
    int rootIndex = -1;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
      nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
        nodes[i] = new Node(i);
			}

      // tree 만들기
      for (int vertex = 0; vertex < n; vertex++) {
          int parentIndex = parent[vertex];

          if (parentIndex == -1) {
            // 루트
            rootIndex = vertex;
          } else {
            // 전부 child
            Node child = new Node(vertex);
            nodes[parentIndex].childNodes.add(child);
          }

      }
		}
		int computeHeight(int root) {
      // 노드 없음
      if (root == -1){
        return 0;
      }

      int max = 0;
      for (int i = 0; i< nodes[root].childNodes.size(); i++) {
        int height = computeHeight(nodes[root].childNodes.get(i).n);
        if (max < height){
          max = height;
        }
      }

			return max + 1;
		}
	}

	static public void main(String[] args) throws IOException {
      new Thread(null, new Runnable() {
          public void run() {
              try {
                  new tree_height().run();
              } catch (IOException e) {
              }
          }
      }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight(tree.rootIndex));
	}
}
