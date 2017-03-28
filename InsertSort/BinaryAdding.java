import java.util.*;

public class BinaryAdding {
  public static void main(String[] args){
    int A[] = {1, 1 , 0, 1, 1};
    int B[] = {1, 1 , 0, 1, 1};

    int C[] = new int[6];

    for(int i=0; i< A.length; i++) {
      C[i] = A[i] + B[i];
    }

    C[C.length -1] = 0;
    for(int i=0; i< C.length-1; i++) {
      int key = C[i];

      if(key == 2) {
        C[i+1]+= 1;
        C[i] = 0;
      } else if(key == 3){
        C[i+1] += 1;
        C[i] = 1;
      }
    }

    System.out.println(Arrays.toString(C));
  }
}
