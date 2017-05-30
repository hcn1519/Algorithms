import java.util.*;

class Node {
  int data;
  boolean headNode;
  boolean visited;
  Node link;
}
class Graph {
  ArrayList<Node> adjList = new ArrayList<>();

  void insertEdge(int v1, int v2){
    if(adjList.size() == 0) {
      Node head = new Node();
      head.data = v1;
      head.headNode = true;
      adjList.add(head);

      Node vertex = new Node();
      vertex.data = v2;
      head.link = vertex;
    } else {
      boolean flag = false;
      for(int i=0; i<adjList.size(); i++){
        if(adjList.get(i).data == v1) {
          flag = true;
        }
      }

      if(flag){
        for(int i=0; i<adjList.size(); i++){
          if(adjList.get(i).data == v1) {
            Node temp = adjList.get(i);
            while(temp.link != null) {
              temp = temp.link;
            }

            Node vertex = new Node();
            vertex.data = v2;

            temp.link = vertex;
          }
        }
      } else {
        Node head = new Node();
        head.data = v1;
        head.headNode = true;
        adjList.add(head);

        Node vertex = new Node();
        vertex.data = v2;
        head.link = vertex;
      }

    }
  }

  void printAdjList(){
    for(int i=0; i<adjList.size(); i++){
      Node temp = adjList.get(i);
      while(temp.link != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.link;
      }
      System.out.print(temp.data);
      System.out.println();
    }
  }

  void BFSTraversal(){
    if (this.adjList.size() == 0) {
      System.out.println("No Vertex");
    } else {
      Node traveler = new Node();
      traveler = adjList.get(0);
      traveler.visited = true;
      System.out.println(traveler.data);

      Queue<Node> qu = new LinkedList<>();
      qu.add(traveler);
      while(qu.peek() != null ){
        traveler = qu.remove();
        System.out.println("trav" + traveler.data);
        while(traveler != null) {
          if(traveler.visited == false && !traveler.headNode) {
            traveler.visited = true;
            System.out.println(traveler.data);
            qu.add(traveler);
          }
          traveler = traveler.link;
        }

      }
    }
  }
}
public class BasicGraph {
  public static void main(String[] args) {
    Graph myGraph = new Graph();
    myGraph.insertEdge(0, 1);
    myGraph.insertEdge(0, 2);
    myGraph.insertEdge(0, 3);
    myGraph.insertEdge(1, 4);
    myGraph.insertEdge(2, 5);
    myGraph.insertEdge(1, 6);
    myGraph.insertEdge(1, 7);
    myGraph.insertEdge(2, 8);
    myGraph.insertEdge(3, 9);

    myGraph.printAdjList();

    myGraph.BFSTraversal();
  }
}
