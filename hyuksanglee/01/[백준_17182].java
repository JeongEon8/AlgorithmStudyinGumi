package 플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon17182 {

	static int[][] map;
	static boolean[] check;
	static int[] dp;
	static int N,K;
	static int best = Integer.MAX_VALUE;
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		map = new int[N][N];
		dp = new int[N];
		
		
		
		for(int n = 0; n<N; n++) {
			input = in.readLine().split(" ");
			for(int m = 0; m<N; m++) {
				map[n][m] = Integer.parseInt(input[m]);
			}
		}
		
		for(int k = 0; k<N; k++) {
			for(int n = 0; n<N; n++) {
				for(int m = 0; m<N; m++) {
					if(map[n][m] > map[n][k]+map[k][m]) {
						map[n][m] = map[n][k]+map[k][m];
					}
				}
				
			}
		}
		
		
		
			check = new boolean[N];
			check[K] = true;
			dfs(K,0,1);
		
		
		
		
		System.out.print(best);

	}
	
	
	static void dfs( int n, int sum, int count) {
		if (sum >= best) return;
		 // 모두 방문했으면 종료
        if (count == N) {
            best = Math.min(best, sum);
            return;
        }
        
		for(int i = 0; i<N; i++) {
			
			if(!check[i]) {
				check[i] = true;
				int total = sum+map[n][i];
				count++;
				dfs(i,total,count);
				count--;
				check[i] = false;
			}
		}
		
	}
	

}
