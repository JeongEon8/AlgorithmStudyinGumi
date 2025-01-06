package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

public class Beakjoon11725 {
	
	static ArrayList<ArrayList<Integer>> arrList; // 서로 연결된 노드 배열
	static int[] result;	// 각 노드에 상위노드 받는 배열
	static boolean[] check;	// 해당 노드에 방문여부 배열
	static int N; // 노드의 수
	
	public static void dfs(int i) {
		
		check[i] = true; // 방문 여부 true
		
		for(int n : arrList.get(i)) {
			if(check[n]== false) { // 방문 하지않았을때 
				result[n]=i; // 해당 노드에 상위노드(i) 입력
				
				dfs(n); // 해당 노드 dfs 탐색시작
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N(노드의 수) 입력받기
		
		// 배열 초기
		arrList = new ArrayList<>();
		result = new int[N+1];
		check = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			arrList.add(new ArrayList<>());
		}
		
		
		// 입력받은 두 노드 arrList에 서로 연결해주
		for(int i =0; i<N-1; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
			
		}
		
		dfs(1); // 최상위 1에서 dfs 시작
		
		for(int i = 2; i<=N; i++) {
			System.out.println(result[i]);
		}
		
		
	}

}
