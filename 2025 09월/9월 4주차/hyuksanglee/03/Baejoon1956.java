package beakjoon;

import java.io.*;
import java.util.Arrays;

public class Baejoon1956 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int INF = Integer.MAX_VALUE;
		
		int [][]arr = new int[V+1][V+1]; 
		for(int v = 0; v<V+1; v++) {
			for(int v1 = 0; v1<V+1; v1++) {
			arr[v][v1] = Integer.MAX_VALUE;
			}
		}
		
		for(int e = 0; e<E; e++) {
			input = in.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			arr[a][b]=c;
		}
		
		for (int k = 1; k <= V; k++) {
		    for (int i = 1; i <= V; i++) {
		        for (int j = 1; j <= V; j++) {
		            if (arr[i][k] != INF && arr[k][j] != INF) {
		                arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
		            }
		        }
		    }
		}
		
//		for (int i = 0; i < V+1; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
		int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                if (arr[i][j] == INF || arr[j][i] == INF) continue;
                int cycle = arr[i][j] + arr[j][i];
                if (cycle < ans) ans = cycle;
            }
        }
        if(ans== INF) {
        	ans=-1;
        }
        System.out.println(ans);
	}

}
