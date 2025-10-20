package 그래프;

import java.io.*;
import java.util.*;

public class Baekjoon1043 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));

		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]); //사람수
		int M = Integer.parseInt(input[1]); // 파티수
		
		input = in.readLine().split(" ");
		
		boolean[] arr = new boolean[N+1];
		boolean[][] map = new boolean[N+1][N+1];
		List[] party = new ArrayList[M];
		
		
		
		int K = Integer.parseInt(input[0]);
		for(int k = 0; k<K; k++) {
			arr[Integer.parseInt(input[k+1])]=true;
		}
		
		for(int m=0; m<M; m++) {
			
			party[m] = new ArrayList();
			
			input = in.readLine().split(" ");
			int num = Integer.parseInt(input[0]); // 파티에 참여하는 사람수
			
			int[] p = new int[num];
			for(int i = 0; i<num; i++) {
				p[i] = Integer.parseInt(input[i+1]);
				party[m].add(p[i]);
				}
			
			for(int i = 0; i<num; i++) {
				int a = p[i];
				for(int j = i+1; j<num; j++) {
					int b = p[j];
					map[a][b] = true;
					map[b][a] = true;
				}
			}
			
		}
		
		Queue<Integer> que = new ArrayDeque();
		
		for(int i = 0; i<N+1; i++) {
			if(arr[i]) {
				que.add(i);
			}
		}
		
		boolean[] check = new boolean[N+1];
		
		while(!que.isEmpty()) {
			int p = que.poll();
			check[p]= true;
			arr[p] = true;
			for(int i = 1; i<N+1; i++) {
				if(map[p][i] && !check[i]) {
					check[i] = true;
					arr[i] = true;
					que.add(i);
				}
			}
		
		}
		
		int count = 0;
		for(int m = 0; m<M; m++) {
			int ch = 0;
			for(int i = 0; i< party[m].size(); i++) {
				if(arr[(int)party[m].get(i)]) {
					ch =1;
					break;
				}
			}
			if(ch==0) {
				count++;
			}
			
		}
		
		
		System.out.print(count);
		
	}

}
