package beakjoon;

import java.io.*;
import java.util.ArrayList;

import java.util.Stack;

public class Sw4012 {

	static int N, min;
	static Stack<Integer> ingredientA;
	static Stack<Integer> ingredientB;
	static boolean[] isSelected;
	static int[][] arr;
	int[] notarr;
	static ArrayList<int[]> arr1;

	public static void dfs(int n) {
		
		// M 개수 일때 계산을 하거나 리턴
		if (n == N) {
			if (ingredientB.size() == N / 2) {
				int cookA = 0, cookB = 0;
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < N / 2; j++) {
						cookA += arr[ingredientA.get(i)][ingredientA.get(j)];
						cookB += arr[ingredientB.get(i)][ingredientB.get(j)];
					}
					
				}
				int result = Math.abs(cookA - cookB);
				if (min > result) {
					min = result;
				}
			}
			return;
		}

		// a음식에 재료 넣기
		ingredientA.push(n);
		dfs(n + 1); 
		ingredientA.pop(); // 넣은 재료 빼기
		
		// b음식에 재료 넣기
		ingredientB.push(n);
		dfs(n + 1);
		ingredientB.pop(); // 넣은 재료 빼기

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine()); // 케이스 개수 받기

		for (int t = 1; t <= T; t++) { // 케이스 수 만큼 반복하기

			N = Integer.parseInt(in.readLine()); // 재료 개수 받기
			arr = new int[N][N]; // 재료담느 배열 초기화
			min = Integer.MAX_VALUE; // 최솟값 받는 변수

			ingredientA = new Stack<Integer>();
			ingredientB = new Stack<Integer>();
			
			// 배열에 재료 담기
			for (int n = 0; n < N; n++) {
				String[] input = in.readLine().split(" ");
				for (int i = 0; i < N; i++) {
					arr[n][i] = Integer.parseInt(input[i]);
				}
			}
			
			// dfs
			dfs(0);

			System.out.println("#"+t+" "+min);

		}
	}

}
