package beakjoon;

import java.io.*;

public class Beakjoon1010 {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[30][30]; // 30 x 30 배열 선언
		
		for(int i =0; i<30; i++) {  // N이 1인경우 M숫자만큼이라 M 입력
			arr[1][i]=i;
		}
		
		for(int i =0; i<30; i++) { // N이랑 M이 같으면 경우의 수 1이라 1입
			arr[i][i]=1;
		}
		
		// 점화식 : N2 : M3 에서 N2 : M4로 추가된 경우
		// N에서 2번째는 경우의 수가 2가지이다.
		// N2 -> M3과 N2 -> M4밖에 없다.
		// N2 -> M3 인 경우는 N2 : M3 경우의 수랑 같고
		// N2 -> M4 인 경우 N1 : M3 랑 경우의 수가 같다.
		// N2 : M4 = (N2 : N3) + (N1 : M3)
		// Na : Mb = ( Na : M(b-1) ) + ( N(a-1) : M(b-1) )
		for(int i =2; i<30; i++) { 
			for(int j = i+1; j<30; j++) {
				arr[i][j]=arr[i][j-1] + arr[i-1][j-1];
			}
		}
		
		// 입력받은 값에 대한 답 출력
		for(int t =0; t<T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			System.out.println(arr[N][M]);
		}
		
		
	}

}
