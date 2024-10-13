package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Baekjoon1937 {

	public static class Place {
		int i;
		int j;
		int count;
	}

	public static int n;
	public static int[][] map;
	public static int[][] isSelected;

	public static int[] di = { 0, 1, 0, -1 };
	public static int[] dj = { 1, 0, -1, 0 };

	public static int dfs(int i, int j) {

		if (isSelected[i][j] != 0) {
			return isSelected[i][j];
		}

		isSelected[i][j] = 1;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || nj < 0 || ni >= n || nj >= n) {
				continue;
			}

			isSelected[i][j] = Math.max(isSelected[ni][nj], dfs(ni, nj) + 1);

		}

		return isSelected[i][j];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		isSelected = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				int result = dfs(i, j);
				if (max < result) {
					max = result;
				}
			}
		}

		System.out.println(max);

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(isSelected[i]));
		}

	}

}
