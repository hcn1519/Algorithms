import java.util.*;

public class BasicQueue {
  public static void main(String[] args) {
    int Q[] = new int[12];
    Node head = new Node();
    Node tail = new Node();
    head.link = 0;
    tail.link = 0;

    enQueue(Q, tail, 3);
    enQueue(Q, tail, 4);
    enQueue(Q, tail, 5);
    enQueue(Q, tail, 6);
    enQueue(Q, tail, 7);
    enQueue(Q, tail, 8);
    enQueue(Q, tail, 9);
    enQueue(Q, tail, 10);
    enQueue(Q, tail, 11);
    enQueue(Q, tail, 12);
    enQueue(Q, tail, 13);
    enQueue(Q, tail, 14);
    enQueue(Q, tail, 13);
    System.out.println(Arrays.toString(Q));

    int de1 = deQueue(Q, head, tail);
    System.out.println(de1);
    int de2 = deQueue(Q, head, tail);
    System.out.println(de2);

  }
  static void enQueue(int[] Q, Node tail, int x) {
    if (!queueIsFull(Q, tail)) {
      Q[tail.link] = x;
      tail.link += 1;
    } else {
      System.err.println("Queue is full!");
    }
  }
  static int deQueue(int[] Q, Node head, Node tail){
    if (!queueIsEmpty(Q, head, tail)){
      int result = Q[head.link];
      head.link += 1;
      return result;
    } else {
      System.out.println("Queue is empty!");
      return -1;
    }
  }
  static boolean queueIsFull(int[] Q, Node tail) {
    if(Q.length == tail.link) {
      return true;
    } else return false;
  }
  static boolean queueIsEmpty(int[] Q, Node head, Node tail) {
    if(head.link == tail.link) {
      return true;
    } else return false;
  }
}
class Node {
  int link;
}
