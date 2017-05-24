import java.util.*;

public class BOJ_2845 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    int peoplePer1m = scin.nextInt();
    int rect = scin.nextInt();
    int realPeopleTotal = peoplePer1m * rect;

    int predictNums[] = new int[5];
    int difNums[] = new int[5];
    for(int i=0; i<5; i++) {
      predictNums[i] = scin.nextInt();
    }

    for(int i=0; i<5; i++) {
      difNums[i] = predictNums[i] - realPeopleTotal;
      System.out.print(difNums[i] + " ");
    }


  }
}
