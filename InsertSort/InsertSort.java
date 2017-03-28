import java.util.*;

public class InsertSort {
  public static void main(String[] args){
    int test[] = {31, 41, 59, 26, 41, 58};

    System.out.println(Arrays.toString(test));

    for(int j=1; j<test.length; j++) {
      int key = test[j];
      int i = j - 1;
      while(i >= 0 && test[i] > key) {
        test[i+1] = test[i];
        i = i-1;
      }
      test[i+1] = key;
    }
    
    System.out.println(Arrays.toString(test));
  }
}
