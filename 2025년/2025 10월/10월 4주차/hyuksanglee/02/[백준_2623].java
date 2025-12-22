package 위상정렬;

import java.io.*;
import java.util.*;

public class Baekjoon2623 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] arr = new int[N+1];
		boolean[] check = new boolean[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<M; i++) {
			input = in.readLine().split(" ");
			int C = Integer.parseInt(input[0]);
			for(int c=1; c<C; c++) {
				int a = Integer.parseInt(input[c]);
				int b = Integer.parseInt(input[c+1]);
				arr[b]++;
				list[a].add(b);
			}
		}
		
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i =1; i<N+1; i++) {
			if(arr[i]==0) {
				que.add(i);
				check[i] =true;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		
		while(!que.isEmpty()) {
			int num = que.poll();
			result.add(num);
			for(int nu: list[num]) {
				arr[nu]--;
				if(arr[nu]==0 && !check[nu]) {
					que.add(nu);
					check[nu]=true;
				}
			}
		}
		
		if(result.size()<N) {
			System.out.println(0);
		}else {
			for(int n: result) {
				System.out.println(n);
			}
			
		}
	}

}
