package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1963 {
	
	static class Num{
		int num;
		int count;
	}

	static boolean[] decimal;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		decimal = new boolean[10000];
		for(int i = 2; i< 10000; i++) {
			if(decimal[i]) {
				continue;
			}
			int n = 2;
			while(n * i <10000) {
				decimal[n * i] = true;
				n++;
			}
		}

		int T = Integer.parseInt(in.readLine());
		for(int t = 0; t<T; t++) {
			String[] input = in.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			int re = bfs(start, end);
			
			System.out.println(re);
		}
		
	}
	
	static int bfs(int s, int e) {
		
		Queue<Num> que = new ArrayDeque();
		
		boolean[] isVisite = new boolean[10000];
		
		Num nu = new Num();
		nu.num =s;
		nu.count = 0;
		que.add(nu);
		while(!que.isEmpty()) {
			Num newNu = que.poll();
			int n = newNu.num;
			int ten = 1;
			if(n == e) {
				return newNu.count;
			}
			for(int i=0; i<4; i++) {
				ten*= 10;
				int share = n/ten;
				share *= ten;
				int t = ten / 10;
				int remain =n%t;
				
				for(int j =0; j<10; j++) {
					
					int addNum = j * t;
					int result =addNum + remain + share;
					
					if(!decimal[result] && result >1000 && !isVisite[result]) {
						isVisite[result] = true;
						Num cNu = new Num();
						cNu.num = result;
						cNu.count = newNu.count +1;
						que.add(cNu);
					}
				}
			}
			
		}
		
		return 0;
	}

}
