import java.util.*;

public class BOJ_10871 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    int n = scin.nextInt();
    int x = scin.nextInt();

    int arr[] = new int[n];

    for(int i=0; i<arr.length; i++){
      arr[i] = scin.nextInt();
    }

    for(int i=0; i<arr.length; i++){
      if(arr[i] < x){
        System.out.print(arr[i] + " ");
      }
    }
  }
}
