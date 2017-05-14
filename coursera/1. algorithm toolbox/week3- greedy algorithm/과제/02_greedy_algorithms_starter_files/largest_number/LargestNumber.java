import java.util.*;

public class LargestNumber {

    private static String largestNumber(ArrayList<String> s) {
        //write your code here
        String result = "";
        int index = 0;
        while(true){
            char max = s.get(0).charAt(0);
            index = 0;
            for(int j=0; j< s.size(); j++){
              if(Character.getNumericValue(max) < Character.getNumericValue(s.get(j).charAt(0))){
                max = s.get(j).charAt(0);
                index = j;
              }
              else if(Character.getNumericValue(max) <= Character.getNumericValue(s.get(j).charAt(0))){
                String s1 = s.get(index) + s.get(j);
                String s2 = s.get(j) + s.get(index);

                int num1 = Integer.parseInt(s1);
                int num2 = Integer.parseInt(s2);
                if(num1 < num2){
                  max = s.get(j).charAt(0);
                  index = j;
                }
              }
            }
            result += s.get(index);
            s.remove(index);
            if (s.isEmpty()) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }
}
