import java.util.*;

public class BOJ_10809 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    String input = scin.next();

    int resultArr[] = new int[26];

    for(int i=0; i<resultArr.length; i++){
      resultArr[i] = -1;
    }

    for(int i=0; i<input.length(); i++){

      if (resultArr[(int)input.charAt(i) - 97] == -1){
          resultArr[(int)input.charAt(i) - 97] = i;
      }

    }
    for(int i=0; i<resultArr.length; i++){
      System.out.print(resultArr[i] + " ");
    }
  }
}
