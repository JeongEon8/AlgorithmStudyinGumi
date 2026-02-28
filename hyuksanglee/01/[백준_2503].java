package 시뮬레이션;

import java.io.*;
import java.util.*;

public class Baekjoon2503 {
	

	static boolean[] check;
	static Queue<String>que;
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		que = new ArrayDeque<String>();
		check = new boolean[10];
		dfs(0,"");
		
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			String aw = input[0];
			int S = Integer.parseInt(input[1]);
			int B = Integer.parseInt(input[2]);
			Queue<String>newQue = new ArrayDeque<String>();
			
			while(!que.isEmpty()) {
				String st = que.poll();
				int[] result =find(aw, st);
				if(result[0] == S && result[1] == B) {
					newQue.add(st);
				}
			}
			que = newQue;
		}
		
		System.out.println(que.size());

	}
	
	static int[] find(String aw, String st) {
		int[] result = new int[2];
		
		int B = 0;
		int S = 0;
		for(int i = 0 ; i<3; i++) {
			char a = aw.charAt(i);
			for(int j =0; j<3; j++) {
				char s = st.charAt(j);
				if(a == s ) {
					if(i == j) {
						S++;
					}else {
						B++;
					}
				}
			}
		}
		
		result[0] = S;
		result[1] =B;
		
		return result;
	}
	
	static void dfs(int depth,String total) {
		if(depth == 3) {
			que.add(total);
			return;
		}
		
		for(int i = 1; i<=9; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(depth + 1, total + i);
				check[i] = false;
			}
		}
		
		
		
	}

}
