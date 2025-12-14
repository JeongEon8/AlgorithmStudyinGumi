import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] info = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			Arrays.sort(info[i]);
		}
		int[] score = new int[n];
		for (int i = 0; i < m; i++) {
			int max = 0;
			for (int j = 0; j < n; j++) {
				max = Math.max(max, info[j][i]);
			}
			for (int j = 0; j < n; j++) {
				if (info[j][i] == max) {
					score[j]++;
				}
			}
		}
		int highScore = 0;
		for (int i = 0; i < n; i++) {
			highScore = Math.max(highScore, score[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (score[i] == highScore) {
				sb.append(i + 1).append(" ");
			}
		}
		System.out.println(sb);

	}

}