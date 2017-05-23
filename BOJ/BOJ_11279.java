import java.util.*;

class BOJ_11279 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);

    int count = scin.nextInt();
    Heap heap = new Heap();

    for(int i=0; i<count; i++) {
      int input = scin.nextInt();

      if(input == 0){
        System.out.println(heap.extractMax());
      } else {
        heap.insert(input);

      }
    }

  }
}

class Heap {
  ArrayList<Integer> dataArr = new ArrayList<>();
  int size = 0;

  int parent(int i) {
    return i/2;
  }
  int child(int i, Boolean isLeft) {
    if (isLeft) {
      return 2*i;
    } else {
      return 2*i+1;
    }
  }
  void swap(int parentIndex, int childIndex) {
    int temp = dataArr.get(parentIndex);
    int temp2 = dataArr.get(childIndex);
    dataArr.set(parentIndex, temp2);
    dataArr.set(childIndex, temp);
  }

  public int extractMax() {
    if (size == 0) {
      return 0;
    }

    int result = dataArr.get(0);
    // System.out.println("현재 Size: " + size);
    dataArr.set(0, dataArr.get(size-1));

    siftDown(1);

    dataArr.remove(size-1);
    size--;
    // System.out.println("줄어든 Size: " + size);
    // System.out.println(Arrays.toString(dataArr.toArray()));
    return result;
  }
  public void insert(int input) {
    size++;
    dataArr.add(input);

    // siftUp : 해당 데이터의 위치 찾아주기
    siftUp(size);
    // System.out.println(Arrays.toString(dataArr.toArray()));
  }
  private void siftUp(int i) {
    while (i>1 && dataArr.get(parent(i)-1) < dataArr.get(i-1)) {
      swap(parent(i)-1, i-1);
      i = parent(i);
    }
  }
  private void siftDown(int i) {
    int maxIndex = i;
    Boolean foundPlace = false;
    // System.out.print("siftDown 직전 : ");
    // System.out.println(Arrays.toString(dataArr.toArray()));

    while (maxIndex*2 < dataArr.size() && !foundPlace) {
      // 자신이 자식들보다 크면 멈춤
      if (dataArr.get(maxIndex-1) < dataArr.get(child(maxIndex, true)-1) || dataArr.get(maxIndex-1) < dataArr.get(child(maxIndex, false)-1)) {
        // 왼쪽과 오른쪽 중 큰 곳 파악
        if (dataArr.get(child(maxIndex, true)-1) > dataArr.get(child(maxIndex, false)-1)) {
          maxIndex = child(maxIndex, true);

        } else {
          maxIndex = child(maxIndex, false);
        }
      }

      // System.out.println("maxIndex : " + maxIndex);
      // System.out.println("i : " + i);

      // 변화가 있으면 자리 바꿈
      if (maxIndex != i) {
        swap(maxIndex-1, i-1);
        i = maxIndex;
        // System.out.print("swap 후 : ");
        // System.out.println(Arrays.toString(dataArr.toArray()));
      } else {
        foundPlace = true;
      }
    }
  }
}
