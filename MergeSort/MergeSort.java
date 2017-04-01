import java.util.*;

public class MergeSort {
  public static void main(String[] args) {
      int myArr[] = {3, 41, 52, 26, 38, 57, 9, 49};

      // int myArr[] = {1, 23, 32, 45, 6, 8, 30, 36};

      mergeSortDividing(myArr, 0, myArr.length - 1);
      System.out.println(Arrays.toString(myArr));
  }

  // 1. 분할하기
  static void mergeSortDividing(int[] A, int p, int r){
    if(p < r){ // 분할을 막는 조건(p와 r이 같으면 호출 안됨)
      int q = (p+r)/2;
      mergeSortDividing(A, p, q);
      mergeSortDividing(A, q+1, r);
      merge(A, p, q, r);
    }
  }
  // 2. 합치기
  // 전체 넘어오는 배열 A[p..r]
  // 이를 A[p..q-1]과 A[q..r] 나눔
  static int[] merge(int A[], int p, int q, int r){
    int num1 = q - p +1; // 4
    int num2 = r - q; // 4

    int L[] = new int[num1+1];
    int R[] = new int[num2+1];

    for(int i=0; i<L.length-1; i++)
        L[i] = A[p + i]; // A[0], A[1], A[2], A[3]

    for(int i=0; i<R.length-1; i++)
        R[i] = A[q + i + 1]; // A[4], A[5], A[6], A[7]

    L[num1] = -1;
    R[num2] = -1;

    int i = 0;
    int j = 0;
    System.out.println(Arrays.toString(L));
    System.out.println(Arrays.toString(R));
    for(int k = p; k<=r; k++){ // 0부터 7까지 모두 설정
      if(i == L.length - 1){ // 한 쪽이 경계점 도달하면 다른 쪽 값을 연속으로 넣는 설정
        if(j != R.length - 1){
          A[k] = R[j];
          j +=1;
          continue;
        } else break;
      } else if(j == R.length - 1){
        if(i != L.length - 1){
          A[k] = L[i];
          i += 1;
          continue;
        } else break;
      }

      if (L[i] <= R[j]) {
        A[k] = L[i];
        i += 1;
      } else {
        A[k] = R[j];
        j += 1;
      }
    }
    return A;
  }
}
