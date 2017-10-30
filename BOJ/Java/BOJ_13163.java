import java.util.*;

public class BOJ_13163 {
  public static void main(String[] args) {
    Scanner scin = new Scanner(System.in);

    String rawNum = scin.nextLine();
    int num = Integer.parseInt(rawNum);

    for(int i=0; i<num; i++) {

        String data = scin.nextLine();
        String[] pieces = data.split(" ");

        pieces[0] = "god";

        String result = "";
        for(int j=0; j<pieces.length; j++)
          result += pieces[j];

        System.out.println(result);

    }

  }
}
