import java.util.*;

public class BOJ_1546 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    double num = scin.nextDouble();

    double score[] = new double[(int)num];

    for(int i=0; i<score.length; i++){
      score[i] = scin.nextDouble();
    }

    double max = score[0];
    for(int i=1; i<score.length; i++){
      if(max < score[i]){
        max = score[i];
      }
    }

    // System.out.println(max);
    // System.out.println(Arrays.toString(score));
    double editScore[] = new double[(int)num];
    for(int i=0; i<editScore.length; i++){
      editScore[i] = (score[i] / max)*100;
    }

    // System.out.println(Arrays.toString(editScore));

    double result = 0;
    for(int i=0; i<editScore.length; i++){
      result += editScore[i];
    }
    result = (result/editScore.length);

    double roundedResult = Math.round(result*100d) / 100d;
    System.out.printf("%.2f",roundedResult);
  }
}
