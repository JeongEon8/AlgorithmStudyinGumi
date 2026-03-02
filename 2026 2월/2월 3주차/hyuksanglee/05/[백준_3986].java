package 스택;

import java.io.*;
import java.util.Stack;

public class Baekjoon3986 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int result = 0;
		for(int n = 0 ; n<N; n++) {
			String input = in.readLine();
			Stack<Character> st =new Stack<>();
			for(int i =0; i<input.length(); i++) {
				char c = input.charAt(i);
				if(st.isEmpty()) {
					st.add(c);
				}else {
					char pc = st.peek();
					if(pc==c) {
						st.pop();
					}else {
						st.add(c);
					}
				}
				
			}
			if(st.size()==0) {
				result++;
			}
			
		}
		
		System.out.print(result);

	}

}
