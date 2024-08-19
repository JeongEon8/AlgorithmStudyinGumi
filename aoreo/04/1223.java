import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
    System.setIn(new FileInputStream("input_1223.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
      int length = sc.nextInt();
      Stack<Character> operator = new Stack<>();
      String expression = "";
      String input = sc.next();
      for (int i = 0; i < length; i++) {
          if(Character.isDigit(input.charAt(i))){
            expression += input.charAt(i);
          }else{
            switch(input.charAt(i)){
              case '(':
              operator.add('(');
              break;
              case ')':
              if(!operator.isEmpty()) {
                while (operator.peek() != '(') {
                  expression += operator.pop();
                  if(operator.isEmpty()) break;
              }
              }
              operator.pop(); 
              break;
              case '+':
              if(!operator.isEmpty()){
                while(operator.peek() == '*' || operator.peek() == '+') {
                  expression += operator.pop();
                  if(operator.isEmpty()) break;
              }
              }
              operator.add('+');
              break;
              case '*':
              if(!operator.isEmpty()) {
                while(operator.peek() == '*') {
                  expression += operator.pop();
                  if(operator.isEmpty()) break;
              }
              }
              operator.add('*');
              break;
            }
          }
      }
      while(!operator.isEmpty()) expression += operator.pop();
      Stack<Integer> operand = new Stack<>();
      
      for(int i = 0; i < expression.length(); i++) {
        if(Character.isDigit(expression.charAt(i))) {
          operand.add(Character.getNumericValue(expression.charAt(i)));
        } else {
          int second = operand.pop();
          int first = operand.pop();
          if(expression.charAt(i) == '+') operand.add(first+second);
          else if(expression.charAt(i) == '*') operand.add(first*second);
        }
      }
      System.out.println("#"+test_case+" "+operand.peek());
		}
	}
}
