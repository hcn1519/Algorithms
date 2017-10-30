import java.util.*;

public class BOJ_11725 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    int num = scin.nextInt();

    int parent[] = new int[num+1];
    int rank[] = new int[num+1];

    rank[1] = 1;
    for(int i=1; i<=num; i++){
      parent[i] = i;
    }


    for(int i=1; i<num; i++) {
      int node1 = scin.nextInt();
      int node2 = scin.nextInt();

      if (node1 == 1) {

      } else if (node2 == 1) {

      }

    }


    System.out.println(Arrays.toString(parent));

    for(int i=2; i<=num; i++) {
      System.out.println(trees[i]);
    }
  }
}
