package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon14938 {

	
	static int n; 
	static int m; 
	static int r;
	static int result;
	
	static int[] t;
	static int[][] map;
	
	
	static class Info{
		int num;
		int sum;
		Info(int num, int sum){
			this.num = num;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		r = Integer.parseInt(input[2]);
		t = new int[n];
		map = new int[n][n];
		result = 0;
		
		
		input = in.readLine().split(" ");
		

		for(int i = 0; i<input.length; i++) {
			t[i] = Integer.parseInt(input[i]);
		}
		
		for(int i =0 ; i< r; i++) {
			input = in.readLine().split(" ");
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;
			int c = Integer.parseInt(input[2]);
			
			map[a][b] = c;
			map[b][a] = c;
		}
		
		for(int i =0; i<n; i++) {
			int total = dist(i);
			if(result<total) {
				result = total;
			}
			
		}
		
		System.out.println(result);
	}

	private static int dist(int i) {
		
		int total = t[i];
		
		int[] go = new int[n];
		for(int j =0; j< n; j++) {
			go[j] = Integer.MAX_VALUE;
		}
		go[i]= 0;
		
		Queue<Info> que = new ArrayDeque<>();
		Info info = new Info(i,0);
		
		que.add(info);
		while(!que.isEmpty()) {
			Info data = que.poll();
			int num = data.num;
			for(int j = 0; j<n; j++) {
				if(j == num) {
					continue;
				}
				if( map[num][j] != 0 && map[num][j]+ data.sum <= m && go[j]>map[num][j]+ data.sum) {
					if(go[j]==Integer.MAX_VALUE) {
						total+=t[j];
					}
					
					go[j] = map[num][j]+ data.sum;
					
					Info newData = new Info(j,map[num][j]+ data.sum);
					que.add(newData);
				}
			}
		}
		
		return total;
		
	}

}
