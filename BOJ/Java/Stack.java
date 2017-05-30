import java.util.*;

public class Stack {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    int orders = scin.nextInt();

    customStack st = new customStack();

    String order = scin.nextLine();
    for(int i=0; i<orders; i++){
        String eachOrder = scin.nextLine();
        switch(eachOrder) {
          case "pop":
            System.out.println(st.pop());
          break;
          case "size":
            System.out.println(st.size());
          break;
          case "empty":
            if(st.isEmpty()){
              System.out.println(1);
            } else {
              System.out.println(0);
            }
          break;
          case "top":
            System.out.println(st.peek());
          break;
          default:
          // push 1
            String splited[] = eachOrder.split("\\s+");
            String temp=splited[1];

            int item = Integer.parseInt(temp);
            st.push(item);
          break;
        }
    }


  }
}

class customStack {
  int top;
  ArrayList<Integer> data = new ArrayList<>();

  customStack(){
    this.top = 0;
    data.add(-1);
  }
  boolean isEmpty(){
    return (this.top == 0);
  }

  void push(int item){
    top += 1;
    data.add(item);
  }

  int pop(){
    if(isEmpty()){
      return -1;
    } else {
      int result = data.get(top);
      data.remove(top);
      top -= 1;
      return result;
    }
  }

  int size(){
    return (data.size() - 1);
  }
  int peek() {
    if (isEmpty()){
      return -1;
    } else {
      return data.get(top);
    }
  }
}
