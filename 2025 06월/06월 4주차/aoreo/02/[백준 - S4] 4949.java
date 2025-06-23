import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = bf.readLine();
            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack();
            String answer = "yes";

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '.') {
                    break; 
                }else if (c == '(' || c == '[') {
                    stack.push(c); 
                }else if (c == ']' && stack.size() > 0) {
                    if (stack.pop() != '[') {
                        answer = "no";
                        stack.clear();
                        break;
                    }
                } else if (c == ')' && stack.size() > 0) {
                    if (stack.pop() != '(') {
                        answer = "no";
                        stack.clear();
                        break;
                    }
                } else if ((c == ']' || c == ')') && stack.size() == 0) {
                    answer = "no";
                    stack.clear();
                    break;
                }
            }

            if (stack.size() > 0) {
                answer = "no";
            }
            stack.clear();
            System.out.println(answer);
        }
    }
}
