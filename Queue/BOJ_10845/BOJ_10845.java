import java.util.*;

public class BOJ_10845 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    int count = scin.nextInt();

    Queue qu = new Queue();

    qu.enQueue(3);

    qu.enQueue(4);

    qu.printQueue();
    // for(int i=0; i<count; i++){
    //   String order = scin.next();
    //   if (order.equals("pop")) {
    //
    //   } else if (order.equals("size")) {
    //
    //   } else if (order.equals("empty")) {
    //
    //   } else if (order.equals("front")) {
    //
    //   } else if (order.equals("back")) {
    //
    //   } else {
    //     // push
    //
    //   }
    // }
  }
}
class Node {
  int data;
  Node link;
}
class Queue {
  Node head;
  Node tail;

  Queue(){
    this.head = null;
    this.tail = null;
  }

  boolean isEmpty(){
    if (this.head == null){
      return true;
    } else return false;
  }
  void enQueue(int item){
    Node newNode = new Node();
    newNode.data = item;
    if (isEmpty()){
      head = newNode;
      tail = newNode;
    } else {
      this.tail.link = newNode;
      this.tail = newNode;
    }
  }
  int deQueue(){
    if(isEmpty()){
      return -1;
    } else {
      int item = this.head.data;
      this.head = this.head.link;
      return item;
    }
  }

  void printQueue(){
    Node temp = new Node();
    temp = this.head;

    while(temp.link != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.link;
    }
    System.out.print(temp.data);
  }

}
