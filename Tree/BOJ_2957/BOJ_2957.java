import java.util.*;

class Node {
  int data;
  Node left;
  Node right;
}

class BinarySearchTree {
  int counter = 0;
  Node insertNode(Node root, int data){
    if (root == null) {
      root = makeNode(data);
      return root;
    } else if (root.data < data) {
      root.right = insertNode(root.right, data);
    } else {
      root.left = insertNode(root.left, data);
    }
    counter += 1;
    return root;
  }
  Node makeNode(int data){
    Node newNode = new Node();
    newNode.data = data;
    return newNode;
  }

  boolean searchNode(Node root, int data){
    if(root == null) {
      return false;
    } else if (root.data == data){
      return true;
    } else if (root.data < data) {
      return searchNode(root.right, data);
    } else {
      return searchNode(root.left, data);
    }
  }
}

public class BOJ_2957 {
  public static void main(String[] args) {
      Scanner scin = new Scanner(System.in);
      int length = scin.nextInt();

      BinarySearchTree BST = new BinarySearchTree();
      Node root = null;

      int counter[] = new int[length];
      for(int i=0; i<length; i++){
          int num = scin.nextInt();
          root = BST.insertNode(root, num);
          counter[i] = BST.counter;
      }
      for(int i=0; i<length; i++){
        System.out.println(counter[i]);
      }

      // root = BST.insertNode(root, 10);
      // root = BST.insertNode(root, 15);
      // root = BST.insertNode(root, 20);

      // System.out.println(BST.searchNode(root, 12));
      // System.out.println(BST.searchNode(root, 10));
      // System.out.println(BST.searchNode(root, 20));
  }
}
