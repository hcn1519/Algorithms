import java.util.*;

class Node {
  String key;
  Node leftChild;
  Node rightChild;
}
public class BOJ_1991 {
    static ArrayList result1 = new ArrayList<String>();
    static ArrayList result2 = new ArrayList<String>();
    static ArrayList result3 = new ArrayList<String>();
    static void preorderTraverse(Node node) {
      result1.add(node.key);
      // System.out.println(node.key);
      if (node.leftChild != null) {
          preorderTraverse(node.leftChild);
      }
      if (node.rightChild != null) {
        preorderTraverse(node.rightChild);
      }
    }
    static void inorderTraverse(Node node) {
      if (node.leftChild != null) {
          inorderTraverse(node.leftChild);
      }
      result2.add(node.key);
      // System.out.println(node.key);
      if (node.rightChild != null) {
        inorderTraverse(node.rightChild);
      }
    }
    static void postorderTraverse(Node node) {
      if (node.leftChild != null) {
          postorderTraverse(node.leftChild);
      }
      if (node.rightChild != null) {
        postorderTraverse(node.rightChild);
      }
      result3.add(node.key);
      // System.out.println(node.key);
    }
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int num = scin.nextInt();

        Node nodes[] = new Node[num];

        for(int i=0; i<num; i++){
          Node newNode = new Node();
          char x =(char)(65+i);
          newNode.key = Character.toString(x);
          nodes[i] = newNode;
        }

        for(int i=0; i<num; i++){
          String key = scin.next();
          String left = scin.next();
          String right = scin.next();

          char x = key.charAt(0);
          int keyIndex = x-65;

          if (!left.equals(".")) {
            char y = left.charAt(0);
            int leftIndex = y-65;
            nodes[keyIndex].leftChild = nodes[leftIndex];
          }

          if (!right.equals(".")) {
            char z = right.charAt(0);
            int rightIndex = z-65;
            nodes[keyIndex].rightChild = nodes[rightIndex];
          }
        }

        preorderTraverse(nodes[0]);
        inorderTraverse(nodes[0]);
        postorderTraverse(nodes[0]);

        for(int i=0; i<result1.size(); i++){
          System.out.print(result1.get(i));
        }
        System.out.println();
        for(int i=0; i<result1.size(); i++){
          System.out.print(result2.get(i));
        }
        System.out.println();
        for(int i=0; i<result1.size(); i++){
          System.out.print(result3.get(i));
        }
    }
}
