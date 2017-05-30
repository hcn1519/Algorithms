import java.util.*;

public class BOJ_9012 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    int testCase = scin.nextInt();
    int x = 0;
		String parenthesis = "";
    String parenList[] = new String[testCase];
    while(x < testCase){
			parenthesis = scin.next();
      parenList[x] = parenthesis;
			x++;
		}

    boolean result[] = new boolean[testCase];
    for(int i=0; i<parenList.length; i++) {
      result[i] = checkVPS(parenList[i]);
    }
    for(int i=0; i<result.length; i++){
      if (result[i]) {
          System.out.println("YES");
      } else {
          System.out.println("NO");
      }

    }
  }

  static boolean checkVPS(String target) {
    Stack st = new Stack();

    for(int i=0; i<target.length(); i++){
      st.push(target.charAt(i));
    }

    int openBracketNeeds = 0;
    for(int i=0; i<target.length(); i++){
      Character temp = (Character) st.pop();
      if (temp == ')') {
        openBracketNeeds += 1;
      }
      else {
        openBracketNeeds -= 1;
        if (openBracketNeeds < 0){
          break;
        }

      }
    }

    if(openBracketNeeds == 0){
      return true;
    } else return false;
  }

}
