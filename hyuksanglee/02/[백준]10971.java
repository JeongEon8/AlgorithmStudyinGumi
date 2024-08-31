package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon10971 {
	
	// 도시의 개수입력받는 변수
	static int N;
	
	//최솟값을 저장하는 변수
	static int min;
	
	// 각 도시에 가는 비용을 저장하는 배열
	static int[][] arr;
	
	
	
	// 방문 처리 하는 배열
	static boolean [] isSelected;
	
	
	
	
	// dfs
	public static void dfs(int n, int sum, int num) { // n: 현제 위치, sum : 지금까지 비용, num:dfs 들어온 횟수
		
		if(num==N && arr[n][0] != 0) { //
			if(min> sum+ arr[n][0]) {
				sum+= arr[n][0];
				min=sum;
			}
			return;
		}
		
		
		for(int i =0; i<N; i++) {
			if(isSelected[i]== false && arr[n][i]!=0) {
				isSelected[i]=true;
				dfs(i, sum+ arr[n][i], num+1);
				isSelected[i]=false;
				
			}
		}
	}
	
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		isSelected = new boolean[N];
		for(int i=0; i<N; i++) {
			String[] input = in.readLine().split(" ");
			for(int j =0; j<N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		isSelected[0]=true; // 무조건 0번 도시에서 출발할거라 방문 처리함
		
		int result= Integer.MAX_VALUE; //결과값 최댓값으로 초기화
		
		for(int i =1; i<N; i++) {
			if(isSelected[i]==false && arr[0][i]!=0) {
				isSelected[i] =true;	// 방문처리
				
				min = Integer.MAX_VALUE; // 최댓값으로 초기화
				
				dfs(i ,arr[0][i] ,2);
				
				if(result > min) {
					result = min;
				}
				isSelected[i] =false;
			}
		}
		
		if(result>=2147483647) {
			result=0;
		}
		
		System.out.println(result);
		
		
	}

}
