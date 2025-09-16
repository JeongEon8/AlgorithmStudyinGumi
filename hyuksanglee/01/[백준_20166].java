package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon20166 {

	
	static String[] alp;
	static int N,M,K,len;
	static char[][] map;
	static int[] result;
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
	static HashMap<String, Integer> hash = new HashMap<>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		map = new char [N][M];
		alp = new String[K];
		result = new int[K];
		
		for(int n = 0; n<N; n++) {
			String inputS = in.readLine();
			for(int m = 0; m<M;m++) {
				map[n][m] = inputS.charAt(m);
			}
		}
		
		for(int k = 0; k<K; k++) {
			String inputS = in.readLine();
			alp[k] = inputS;
			if(len<inputS.length()) {
				len=inputS.length();
			}
		}
		
		for(int i =0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(map[i][j]);
				dfs(i,j,1,sb);
			}
		}
		
		
		for (int k = 0; k < K; k++) {
			System.out.println(hash.getOrDefault(alp[k], 0));
		}
		
		
		
	}
	
	static void dfs(int y, int x, int count, StringBuilder total) {
		if(count >=len) {
//			for(int k=0; k<K; k++) {
//				if(alp[k].equals(total)) {
//					result[k]++;
//				}
//			}
			
			return;
		}
		
		for(int d = 0; d<8; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			if(ny<0) {
				ny=N-1;
			}
			if(nx<0) {
				nx = M-1;
			}
			if(ny>=N) {
				ny=0;
			}
			if(nx>=M) {
				nx =0;
			}
			total.append(map[ny][nx]);
			if(hash.containsKey(total.toString())) {
				hash.merge(total.toString(), 1, Integer::sum);
			}else {
				hash.put(total.toString(),1);
			}
			dfs(ny,nx,count+1, total);
			total.setLength(total.length() - 1);
		}
		
	}

}
