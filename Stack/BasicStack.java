import java.util.*;

public class BasicStack {
  // 배열을 통한 스택 구현
  public static void main(String[] args) {
    int S[] = new int[7];
    Node top = new Node();
    top.link = -1;

    push(S, top, 3);
    push(S, top, 4);
    push(S, top, 5);
    push(S, top, 6);
    push(S, top, 7);
    System.out.println(Arrays.toString(S));

    int pop = pop(S, top);
    System.out.println(pop);
    int pop2 = pop(S, top);
    System.out.println(pop2);
  }
  static void push(int[] S, Node top, int x){
    if(top.link != S.length - 1) {
      top.link += 1;
      S[top.link] = x;
    }
  }
  static int pop(int[] S, Node top){
    if (!stackIsEmpty(S, top)) {
      int result = S[top.link];
      top.link -= 1;
      return result;
    } else {
      System.err.println("Stack is empty!");
      return -1;
    }
  }
  static boolean stackIsEmpty(int[] S, Node top){
    if(top.link == -1) {
      return true;
    } else return false;
  }
}

class Node {
  int link;
}
