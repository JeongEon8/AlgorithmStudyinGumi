package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon1976 {
	
	public static boolean [] isSelected;
	public static int[][] arr;
	public static int N,M;
	
	public static void bfs(int nu) {
		Queue<Integer> que = new ArrayDeque();
		que.add(nu);
		while(!que.isEmpty()) {
			
			int num = que.poll();
			isSelected[num] = true;
			for(int n =0; n<N; n++) {
				if(arr[num][n]==1 && isSelected[n]==false) {
					que.add(n);
					isSelected[n]=true;
				}
				
			}
			
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine()); // 도시의 수
		M = Integer.parseInt(in.readLine()); // 여행 계획에 속한 도시들 수
		arr = new int[N][N]; // 도시 연결 여부 배열
		isSelected = new boolean[N]; // 도시 방문 여부를 체크하는 배열
		
		// 입력 받은 도시 연결 여부 배열에 담기
		for (int m = 0; m< N; m++) {
			String[] input = in.readLine().split(" ");
			for(int n =0; n<N; n++) {
				arr[m][n] = Integer.parseInt(input[n]);
			}
		}
		String[] input = in.readLine().split(" ");
		int[] numbers = new int [input.length];
		for(int i = 0; i < input.length; i++){
            numbers[i] = Integer.parseInt(input[i])-1;
        }
		bfs(numbers[0]);
		
		
		boolean check = true;
		for(int n : numbers) {
			if(isSelected[n] == false){
				check=false;
				break;
			}
		}
		
		if(check == false) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
		
	}

}