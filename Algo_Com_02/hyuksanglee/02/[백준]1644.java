package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Beakjoon_1644 {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N 입력 받기
		
		
		int num =0; // 수소의 갯수

		
		 boolean[] isPrime = new boolean[N + 1]; // 에라토스테네스의 체 사용하기 위한 배열
		 int [] arr = new int [N]; // 소수를 담는 배열 
		 
		// 소수의 제곱들은 제외시키기
	        for (int i = 2; i * i <= N; i++) { 
	            if (!isPrime[i]) { 
	                for (int j = i * i; j <= N; j += i) { 
	                    isPrime[j] = true;
	                }
	            }
	        }

	     // 소수를 배열에 추가
	        for (int i = 2; i <= N; i++) {
	            if (!isPrime[i]) {
	                arr[num++] = i;
	            }
	        }
		
		
//		for (int i = 2; i <= N; i++) { // N 이하의 자연수들에서 소수 찾기
//			
//			boolean check = true; // 소수인지 확인하는 변수 true : 소수O, false : 소수X
//			for(int j = 2; j<i; j++) {
//				if(i%j ==0) {
//					check = false;
//					break;
//				}
//			}
//			
//			if(check) { // 소수이면 배열에 담기
//				arr[num++] = i;
//			}
//		}
		
		int total = 0; // 연속되는 소수들의 합 
		int arrN = 0 ; // 빼기한 횟수
		int count = 0; // 입력 받은 값과 합이 같은 횟수
		
		for(int i = 0; i<num; i++) { // (투 포인트 구현)
			
			total += arr[i]; // 연속되는 소수 더하기
			
			while(total > N) { // 합이 입력받은 값보다 클 경우
				total -= arr[arrN++]; // 더했던 소수 증에 제일 작은 소수 빼기
			}
			
			if(total == N) {
				total -= arr[arrN++];
				count++; // 횟수 추가
			}
			
			
		}
		System.out.println(count);

	}
}
