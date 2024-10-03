package beakjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon2669 {


	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[101][101];	// 101 x 101 을 담는 배열
		int result = 0;						// 사각형 면적의 합

		// 입력 받기
		for (int n = 0; n < 4; n++) {
			String[] input = in.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]); 
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);
		
			for(int i = x1;i<x2;i++) { 		// x1에서 x2까지
				for(int j =y1; j<y2; j++) {	// y1에서 y2까지
					arr[i][j] =1;			// 직사각형 면적을 1로 표시해준다.
				}
			}

		}
		
		// 좌표를 이중 for문으로 1이 있는 칸이 있으면 result에 +1을 해준다.
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(arr[i][j] ==1) {
					result +=1;
				}
			}
		}
		
		
		System.out.println(result);

	}

}