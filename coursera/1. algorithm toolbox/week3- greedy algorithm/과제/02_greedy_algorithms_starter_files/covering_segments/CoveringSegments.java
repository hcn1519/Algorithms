import java.util.*;

public class CoveringSegments {
    // 선을 가장 오른쪽 것들 부터 왼쪽으로 정렬
    private static int[] sortPoints(int[] points){

      int temp=0;
      for(int i=0; i< (points.length)/2; i++){
        for(int j=i; j< (points.length)/2; j++){
          if(points[2*i+1] < points[2*j+1]){
            temp = points[2*i+1];
            points[2*i+1] = points[2*j+1];
            points[2*j+1] = temp;

            temp = points[2*i];
            points[2*i] = points[2*j];
            points[2*j] = temp;
          }
        }
      }
      return points;
    }
    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }

        points = sortPoints(points);

        ArrayList<Integer> result = new ArrayList<Integer>();

        int i = 0;
        int point = -1;
        while(i< segments.length){
          int start = points[2*i];
          int end = points[2*i+1];
          i++;
          while(i< segments.length && start <= points[2*i+1]){
            if(start<= points[2*i]){
              // 포함될 때
              start = points[2*i];
            }
            end = points[2*i+1];
            point = end;
            i++;
          }
          result.add(end);
        }
        Collections.sort(result);
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> result = optimalPoints(segments);
        System.out.println(result.size());
        for (Integer point : result) {
            System.out.print(point + " ");
        }
    }
}
