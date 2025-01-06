package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Baekjoon9466 {

	static int result;

	static int[] arr;

	static boolean[] isSelcetd;

	public static void dfs(int n, ArrayList<Integer> list) {

		isSelcetd[n] = true;
		
		if (isSelcetd[arr[n]] == false) {
			list.add(n);
			dfs(arr[n], list);
		}else {
			if (n == arr[n]) {
				isSelcetd[arr[n]] = true;
				result += list.size();
				return;
			}
			int index = 0;
			for (int i : list) {
				if (arr[n] == i) {
					result += index;
					return;
				}
				index++;
			}
			result += list.size()+1;
			
			return;
		}
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 받기
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(in.readLine());
			String[] input = in.readLine().split(" ");
			arr = new int[N + 1];
			isSelcetd = new boolean[N + 1];
			for (int n = 1; n <= N; n++) {
				arr[n] = Integer.parseInt(input[n - 1]);
			}

			result = 0;
			for (int n = 1; n <= N; n++) {
				ArrayList<Integer> list = new ArrayList<>();
//				stack.push(n);
				if (isSelcetd[n] == false) {
					isSelcetd[n] = true;
					dfs(n, list);
				}

			}

			System.out.println(result);

		}
	}

}
