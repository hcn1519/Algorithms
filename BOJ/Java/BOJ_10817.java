import java.util.*;

public class BOJ_10817 {
  public static void main(String[] args ){
    Scanner scin = new Scanner(System.in);

    int num[] = new int[3];
    for(int i= 0; i<3; i++){
        String input = scin.next();
        num[i] = Integer.parseInt(input);
    }

    Arrays.sort(num);
    // for(int i=0; i<num.length; i++){
    //   for(int k=1; k<num.length; k++){
    //     if(num[k] < num[i]){
    //       int temp = num[i];
    //       num[i] = num[k];
    //       num[k] = temp;
    //     }
    //   }
    // }

    System.out.println(num[1]);

  }
}
