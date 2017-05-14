import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        Boolean isSuccess = true;
        int failIndex = 0;
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket newBracket = new Bracket(next, position);
                opening_brackets_stack.push(newBracket);
            }

            if (next == ')' || next == ']' || next == '}') {
                // empty
                if (opening_brackets_stack.empty()){
                  isSuccess = false;
                  failIndex = position + 1;
                  break;
                }
                Bracket temp = opening_brackets_stack.pop();

                // matching 실패
                if (!temp.Match(next)) {
                  isSuccess = false;
                  failIndex = position + 1;
                  break;
                }
            }
        }

        if (isSuccess){

          if (opening_brackets_stack.empty()){
            System.out.println("Success");
          } else {
            //  스택에 여는 괄호 남아 있는 상태
            Bracket newBracket = opening_brackets_stack.pop();
            isSuccess = false;
            failIndex = newBracket.position + 1;

            System.out.println(failIndex);
          }
        } else {
            System.out.println(failIndex);
        }



    }
}
