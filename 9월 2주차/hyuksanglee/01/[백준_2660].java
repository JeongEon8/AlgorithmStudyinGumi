package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2660 {

	static class Friend{
		int f;
		int count;
		Friend(int f, int c){
			this.f = f;
			count = c;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		boolean[][]arr = new boolean[N+1][N+1];
		int[] total = new int[N+1];
		
		
		String [] input = in.readLine().split(" ");
		int a =Integer.parseInt(input[0]);
		int b =Integer.parseInt(input[1]);
		while(a!=-1 && b!=-1) {
			arr[a][b] = true;
			arr[b][a] = true;
			input = in.readLine().split(" ");
			a =Integer.parseInt(input[0]);
			b =Integer.parseInt(input[1]);
		}
		
		for(int i =1; i<N+1; i++) {
			boolean[] isCheck = new boolean[N+1];
			int count =0;
			Queue<Friend> que = new ArrayDeque();
			
			que.add(new Friend(i,0));
			while(!que.isEmpty()) {
				Friend friend = que.poll();
				isCheck[friend.f]= true;
				for(int j = 1; j<N+1; j++) {
					if(!isCheck[j] && arr[friend.f][j]) {
						que.add(new Friend(j,friend.count+1));
						isCheck[j]= true;
						if(total[i]<friend.count+1) {
							total[i]=friend.count+1;
						}
					}
				}
			}
		}
		int result = Integer.MAX_VALUE;
		int co = 0;
		for(int i = 1; i<N+1; i++) {
			if(result >total[i]) {
				result =total[i];
				co=0;
			}
			if(result ==total[i]) {
				co++;
			}
		}
		
		System.out.println(result+" "+co);
		for(int i = 1; i<N+1; i++) {
			
			if(result ==total[i]) {
				System.out.print(i+" ");
			}
		}
		

	}

}
