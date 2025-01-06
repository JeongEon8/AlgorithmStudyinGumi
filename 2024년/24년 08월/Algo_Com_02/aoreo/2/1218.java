import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
   //  System.setIn(new FileInputStream("input_1218.txt"));
        Scanner sc = new Scanner(System.in);
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
      int answer = 1;
 
      Stack<Integer> stack = new Stack<>();
 
      int length = sc.nextInt();
      String str = sc.next();
      int top = 1;
      for(int i = 0; i < length; i++){
        switch(str.charAt(i)) {
          case '{' : stack.add(-1);
          break;
          case '}' : 
          top = stack.pop();
          if (top != -1) {
            answer = 0;
            i = length -1; // 종료 시키기 위해서
          }
          break;
          case '[' : stack.add(-2);
          break;
          case ']' : 
          top = stack.pop();
          if (top != -2) {
            answer = 0;
            i = length -1; // 종료 시키기 위해서
          }
          break;
          case '(' : stack.add(-3);
          break;
          case ')' : 
          top = stack.pop();
          if (top != -3) {
            answer = 0;
            i = length -1; // 종료 시키기 위해서
          }
          break;
          case '<' : stack.add(-4);
          break;
          case '>' : 
          top = stack.pop();
          if (top != -4) {
            answer = 0;
            i = length -1; // 종료 시키기 위해서
          }
          break;
          default : break;
        }
         
      }
      if (stack.size() != 0) answer = 0;
      System.out.println("#"+test_case+" "+answer);
        }
    }
}
