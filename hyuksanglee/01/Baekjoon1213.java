package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1213 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		
		String input = in.readLine();
				
		int[] isCount = new int[26];
		char[] result = new char [input.length()];
		boolean isCheck= false;
		
		
		for(int i = 0; i<input.length(); i++) {
			int a = input.charAt(i)-'A';
			isCount[a]+=1;
		}
	
		int index = 0;
		for(int i = 0; i<26; i++) {
			if(isCount[i]%2!=0) {
				que.add(i);
				isCount[i]-=1;
			}
			if(que.size()>1) {
				isCheck = true;
				break;
			}
			while(isCount[i]>0) {
				result[index]= (char)(i+'A');
				isCount[i]--;
				result[input.length()-1-index++]= (char)(i+'A');
				isCount[i]--;
			}
		}
		
		if(isCheck) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			if(que.size()>0) {
				int n =que.poll();
				
				result[index]=(char)(n+'A');
			}
			String res = "";
			for(int i =0; i<result.length; i++) {
				res += result[i];
			}
			
			System.out.println(res);
		}
		

	}

}
