package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int L = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];	//각 도시로 가는 버스 비용을 담는 배열

		for (int l = 0; l < L; l++) {
			String[] input = in.readLine().split(" ");
			int A =Integer.parseInt(input[0])-1;
			int B =Integer.parseInt(input[1])-1;
			int C =Integer.parseInt(input[2]);
			
			if(arr[A][B] == 0 ) { 	// 해당 칸이 처음입력하면 값을 입력한다.
				arr[A][B] =C;
			}else if(arr[A][B]>C){	// 입력된 값보다 적은값이면 갱신
				arr[A][B] =C;
			}
			
		}
		
		for(int k =0; k<N; k++) {	// 거치는 점
			for(int s = 0; s<N; s++) {	// 시작 점
				for(int e = 0; e<N; e++) {	// 도착 점
					
					if(s==e || arr[s][k] == 0 || arr[k][e] ==0) {
						continue;
					}
					
					if(arr[s][e]==0 || arr[s][e]>arr[s][k]+arr[k][e]) {
						arr[s][e] = arr[s][k]+arr[k][e];
					}
				}
			}
		}
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(arr[i]));
		}
		

	}

}
