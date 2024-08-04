package beakjoon;

import java.io.*;

public class Beakjoon11658 {

	public static void main(String[] str)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input = br.readLine().split(" "); // N과 M 입력받기
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int [] arr = new int[N+1]; // N크기 만큼 배열초기화
		
		input = br.readLine().split(" "); // 수 입력받기
		
		for (int n = 1; n<=N; n++) { // 누적합으로 배열 넣기
			arr[n] = Integer.parseInt(input[n-1])+arr[n-1];
		}
		
		for(int n = 0; n<M; n++) { 
			input = br.readLine().split(" "); // i와 j입력 받기
			int i = Integer.parseInt(input[0]); 
			int j = Integer.parseInt(input[1]);
			
			System.out.println(arr[j]-arr[i-1]); // j 에서 i -1 을 빼주면 i~j의 합이 된다.
		}
		
		
	}
}
