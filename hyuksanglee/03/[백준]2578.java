package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon2578 {
	public static void main(String[] args)throws Exception {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		int[][]bingo = new int [5][5];
			
		int[] checkW = new int [5]; // 가로 빙고 비교
		int[] checkH = new int [5];	// 세로 빙고 비교
		int[] checkC = new int [2];	// 대각선 빙고 비교
		
		int total =0; // 빙고 수
		
		int count =0;
		
		
		// 입력받은 숫자 빙고 배열에 넣기
		for(int i = 0; i<5; i++) {
			String [] input = in.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		boolean check = false;  // 빙고 여부
		
		// 사회자 번호 받기
		for(int i = 0; i<5; i++) {
			String [] input = in.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				count++;
				int num =  Integer.parseInt(input[j]);
				for(int x = 0; x<5; x++) {
					for(int y = 0; y< 5; y++) {
						if(bingo[x][y] == num) {
							checkW[x] +=1;
							checkH[y] +=1;
							
							if(x==y) { // x==y이면 \에 해당됨
								checkC[0] +=1;
							}
							if (4-x==y) { // 4-x == y 이면 /에 해당됨
								checkC[1] +=1;
							}
							
							if(checkW[x] ==5) {
								total +=1; // 빙고 횟수 한개 추가
								checkW[x] +=1;	// 중복을 막기 위해 한개 더 추가 해준다.
							}
							if(checkH[y] ==5) {
								total +=1; // 빙고 횟수 한개 추가
								checkH[y] +=1;	// 중복을 막기 위해 한개 더 추가 해준다.
							}
							if(checkC[0] == 5) {
								total +=1; // 빙고 횟수 한개 추가
								checkC[0] +=1;	// 중복을 막기 위해 한개 더 추가 해준다.
							}
							if(checkC[1] == 5) {
								total +=1; // 빙고 횟수 한개 추가
								checkC[1] +=1;	// 중복을 막기 위해 한개 더 추가 해준다.
							}
							
							if(total>=3) {
								System.out.println(count);
								check = true;
								break;
							}
							
						}
					}
					
					if(check) {
						break;
					}
				}
				if(check) {
					break;
				}
				
			}
			
			if(check) {
				break;
			}
		}
		
		
	}
}
