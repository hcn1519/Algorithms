import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class mergeSort {
  private static int[] selectionSort(int[] points){
    int temp=0; // swap용 변수 temp
    for(int i=0; i<points.length; i++){
      for(int j=i; j<points.length; j++){
        if(points[i]>points[j]){
          // swap 파트
          temp = points[i];
          points[i] = points[j];
          points[j] = temp;
        }
      }
    }
    return points;
  }
  private static int[] merge(int[] sub1, int[] sub2){
    // System.out.println("merge 대상");
    // System.out.print("sub1 : ");
    // System.out.println(Arrays.toString(sub1));
    // System.out.print("sub2 : ");
    // System.out.println(Arrays.toString(sub2));
    int mergeResult[] = new int[sub1.length + sub2.length];
    int i = 0;
    int index=0;
    int index2=0;
    while(i< mergeResult.length){
      int x = sub1[index];
      int y = sub2[index2];
      if(x < y){
        mergeResult[i] = x;
        index++;
      }
      else {
        mergeResult[i] = y;
        index2++;
      }
      i++;
      if(index == sub1.length){
        while(index2 < sub2.length){
          mergeResult[i] = sub2[index2];
          index2++;
          i++;
        }
        // System.out.print("merge 결과 : ");
        // System.out.println(Arrays.toString(mergeResult));
        return mergeResult;
      } else if(index2 == sub2.length){
        while(index < sub1.length){
          mergeResult[i] = sub1[index];
          index++;
          i++;
        }
        // System.out.print("merge 결과 : ");
        // System.out.println(Arrays.toString(mergeResult));
        return mergeResult;
      }
      // System.out.print("merge 결과 : ");
      // System.out.println(Arrays.toString(mergeResult));
    }
    return mergeResult;
  }
  private static int[] mergeSort(int[] points){
    if(points.length == 1) return points;

    int l = points.length;
    int m = l/2;
    int sub1[] = new int[m];
    int sub2[] = new int[l-m];

    for(int i=0; i<m; i++)
      sub1[i] = points[i]; // 0, 1, 2, 3, 4

    if(l % 2 == 0){
      for(int i=0; i<l-m; i++)
        sub2[i] = points[l-m+i]; // 10-5+0 = 5
    } else {
      for(int i=0; i<l-m; i++)
        sub2[i] = points[l-m+i-1]; // 9-4+0-1 = 4
    }
    // System.out.print("sub1 : ");
    // System.out.println(Arrays.toString(sub1));
    // System.out.print("sub2 : ");
    // System.out.println(Arrays.toString(sub2));
    sub1 = mergeSort(sub1);
    sub2 = mergeSort(sub2);

    int result[] = merge(sub1, sub2);

    return result;
  }
  public static void main(String args[]) {
    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt();
    // int arr[] = new int[n];
    // for(int i=0; i<n; i++)
    //   arr[i] = in.nextInt();
    // System.out.println(Arrays.toString(selectionSort(arr)));
    // System.out.println(Arrays.toString(mergeSort(arr)));

    while(true){
      int length = ThreadLocalRandom.current().nextInt(1, 10000);
      int ran[] = new int[length];


      for(int i=0; i< length; i++){
        int a = ThreadLocalRandom.current().nextInt(1, 10000);
        ran[i] = a;
      }
      int arr1[] = selectionSort(ran);
      int arr2[] = mergeSort(ran);

      if(isSame(arr1, arr2)){
        System.out.println("정렬 결과 같음 ");
      } else {
        System.out.println("값이 다릅니다. ");
        break;
      }
    }
  }
  private static boolean isSame(int[] arr1, int[] arr2){
    if(arr1.length != arr2.length) return false;

    for(int i=0; i< arr1.length; i++){
      if(arr1[i] != arr2[i])
        return false;
    }
    return true;
  }
}
