import java.util.*;

public class BOJ_10039 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);

    int result=0;
    for(int i=0; i<5; i++){
      int score = scin.nextInt();

      if (score < 40) {
        score = 40;
      }
      result += score;
    }

    System.out.println(result/5);
  }
}
