import java.util.*;

public class BOJ_8958 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    int number = scin.nextInt();

    int result[] = new int[number];

    for(int i=0; i<number; i++){
      String data = scin.next();
      result[i] = getScore(data);
    }

    for(int i=0; i<number; i++){
      System.out.println(result[i]);
    }
  }

  static int getScore(String data) {
    Stack st = new Stack();
    int result = 0;
    for(int i=0; i<data.length(); i++){
      if (data.charAt(i) == 'O'){
        st.push(data.charAt(i));
      } else {
        int score = 1;
        while (!st.empty()){
          // System.out.print("pop ");
          Object a = st.pop();
          result += score;
          score++;
        }
      }
    }

    int i = 1;
    while(!st.empty()){
      // System.out.print("pop2 ");
      Object a = st.pop();
      result += i;
      i++;
    }
    return result;
  }
}
