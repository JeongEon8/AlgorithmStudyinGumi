package beakjoon;

import java.io.*;
import java.util.*;

public class Baekjoon16398 {
	
	static int[][] arr;
	static int[] de;
	static boolean[] isVisited;
	static int N;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		de = new int[N];
		isVisited = new boolean [N];
		for(int n = 0; n<N; n++) {
			de[n] = Integer.MAX_VALUE;
			String[] input= in.readLine().split(" ");
			for(int m =0; m<N; m++) {
				arr[n][m] = Integer.parseInt(input[m]);
			}
			
		}
		
		de[0]=0;
		for(int n =0; n<N; n++) {
			pl(0);
		}
		
		
		int result = 0;
		for(int n =0; n<N; n++) {
			result+= de[n];
		}
		System.out.println(result);
		
	}
	
	static void pl(int num) {
		int u = -1;
        int best = Integer.MAX_VALUE;
        
        for (int v = 0; v < N; v++) {
            if (!isVisited[v] && de[v] < best) {
                best = arr[num][v];
                u = v;
            }
        }
        
        isVisited[u] = true;
        for (int v = 0; v < N; v++) {
            if (!isVisited[v] && arr[u][v] < de[v]) {
                de[v] = arr[u][v];
            }
        }
	}

}
