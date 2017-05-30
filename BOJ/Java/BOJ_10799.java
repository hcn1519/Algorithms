import java.util.*;

public class BOJ_10799 {
  public static void main(String[] args){
    Scanner scin = new Scanner(System.in);
    String parenthesis = scin.next();

    ArrayList<Log> allLogs = new ArrayList<>();
    allLogs = makeLog(parenthesis);

    ArrayList<Log> laser = new ArrayList<>();
    ArrayList<Log> logs = new ArrayList<>();

    for(int i=0; i<allLogs.size(); i++){
      Log myLog = allLogs.get(i);
      if(myLog.end - myLog.start == 1) {
        laser.add(myLog);
      } else {
        logs.add(myLog);
      }
    }

    int result = 0;
    for(int i=0; i<logs.size(); i++){
      result += countLogs(laser, logs.get(i));
    }

    System.out.println(result);

  }
  static ArrayList<Log> makeLog(String parenthesis){
      ArrayList<Log> logList = new ArrayList<Log>();
      Stack stLog = new Stack();

      for(int i=0; i<parenthesis.length(); i++){
        Character temp = parenthesis.charAt(i);
        if (temp == '(') {
            Log tempLog = new Log();
            tempLog.start = i;
            stLog.push(tempLog);
        } else {
            Log tempLog = (Log) stLog.pop();
            tempLog.end = i;
            logList.add(tempLog);
        }
      }

      return logList;
  }
  static int countLogs(ArrayList<Log> laser, Log log){
    int result = 1;

    for(int i=0; i<laser.size(); i++){
        int beam = laser.get(i).end;
        if(beam > log.start && beam < log.end) {
          result += 1;
        }
    }

    return result;
  }

}
class Log {
  int start;
  int end;
}
