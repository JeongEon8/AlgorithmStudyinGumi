package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(in.readLine()); // 참외의 개수 받기
		int[] cA = new int[3];
		int[] rA = new int[3];
		int[] total = new int[6];

		int result = 0;
		int indexC = 0;
		int indexR = 0;
		int index = 0;
		int indexMC = 0;
		int indexMR = 0;

		int maxC = 0;
		int maxR = 0;

		// 참외 밭 넓이 받기
		for (int i = 0; i < 6; i++) {

			String[] input = in.readLine().split(" ");
			int w = Integer.parseInt(input[0]); // 방향 1(동), 2(서), 3(남), 4(북)
			int d = Integer.parseInt(input[1]); // 길이

			total[index++] = d;
			
			if (w == 1 || w == 2) {
				cA[indexC++] = d;
				if (maxC < d) {
					maxC = d;
					indexMC = index -1;
				}
			} else {
				rA[indexR++] = d;
				if (maxR < d) {
					maxR = d;
					indexMR = index -1;
				}
			}

		}

		result = maxC * maxR;
		
		int mi = 1;
		for(int i=0; i<6; i++) {
			if(i == indexMC || i == indexMR || i == (indexMC-1+6)%6 || i == (indexMC+1+6)%6 || i == (indexMR-1+6)%6 || i == (indexMR+1+6)%6 ) {
				continue;
			}
			
			mi *= total[i];
		}
		

		System.out.println((result-mi) * K);

	}

}
