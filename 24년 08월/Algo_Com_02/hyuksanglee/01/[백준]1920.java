package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N,M; 
	static int[]arr; // A의 값을 입력받은 배열 
	static String[]str; // 사용자에게 입력 받을 때 담는 배열
	
	// 이진 탐색을 하는 메서드
	public static void Bsh(int n ) {
		int st = 0; // A 배열의 시작 점
		int ed = N-1; // A 배열의 끝 점
		int mid = (st+ed) /2; // 중간 점 
		while(true) {
			if(arr[mid] == n) { // 찾고자하는 값이 있으면 1을 출력하고 종료
				System.out.println(1);
				break;
			}
			
			if(st>ed) { // 시작 점이 끝 점보다 클경우 0을 출력하고 종료
				System.out.println(0);
				break;
			}
			
			if(arr[mid]<n) { // 찾고자하는 값이 중간 값보다 클 경우 
				st = mid +1; // 탐색을 시작 점을 중간 점보다 1크게 설정
			}else { // 찾고자하는 값이 중간 값보다 작을 경우
				ed = mid - 1; // 끝 점을 중간 점보다 1작게 설정
			}
			
			mid = (st + ed) /2; // 변경된 값을 기준으로 중간 점 설정
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); // A의 배열의 크기 설정
		arr = new int [N]; // A 저정할 배열 초기화
		
		str = bf.readLine().split(" "); // A의 배열 요소 입력 받기
		
		for (int j = 0; j<N; j++) {  // 입력받은 A 배열 int 배열로 수정
			arr[j] = Integer.parseInt(str[j]);
		}
		
		Arrays.sort(arr); // 이진 탐색을 위해 A 배열 안에 값들 정렬

		M = Integer.parseInt(bf.readLine()); // 찾고자하는 값들의 수 설정
		
		str = bf.readLine().split(" "); // 찾고자 하는 숫자들 입력 받기
		
		for(int i=0; i<M; i++) { // 차례대로 이진 탐색 시작
			Bsh(Integer.parseInt(str[i])); // 찾고자하는 값 정수로 바꾸어 이진 탐색 
		
		}
	}
}
