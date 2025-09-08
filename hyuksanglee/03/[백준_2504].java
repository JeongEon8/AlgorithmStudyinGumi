package beakjoon;
import java.io.*;
import java.util.Stack;

public class Baekjoon2504 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();
		
		Stack<Character> stack = new Stack();
		
		int result = 0;
		int total = 0;
		
		for(int i =0; i<input.length(); i++) {
			char data = input.charAt(i);
			if(stack.isEmpty()) {
				stack.add(data);
			}else {
				if(data=='('|| data=='[') {
					stack.add(data);
				}else {
					while(!stack.isEmpty()) {
						char ch = stack.pop();
						
					}
				}
				
			}
			
			
		}
		
		System.out.println(result);
	}

}
