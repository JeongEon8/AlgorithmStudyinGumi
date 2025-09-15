package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2447 {

	static int N;
	static int[][] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		
		dfs(0,0,N);
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] == 1 ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
		
	}
	
	static void dfs(int startY,int startX, int n) {
		if(n==1) {
			for(int i =0; i<3;i++) {
				for(int j =0; j<3; j++) {
					if(i==1&& j==1) {
						continue;
					}
					arr[startY+i][startX+j]=1;
				}
			}
			return;
		}else {
			for(int y =0; y<3; y++) {
			    for(int x = 0; x<3; x++ ) {
			        if(x==1 && y==1) {
			            continue;
			        }
			        if(startY+y*n<N && startX+x*n<N)
			        dfs(startY+y*n,startX+x*n,n/3);
			    }
			}
		}
		
	}

}
