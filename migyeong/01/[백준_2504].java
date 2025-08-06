import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504 {
    static String[] split;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int value = 1;

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                value *= 2;
            }
            else if(input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                value *= 3;
            }
            else if(input.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (input.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            }
            else if(input.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (input.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");
        System.out.println(sb);

    }
}
