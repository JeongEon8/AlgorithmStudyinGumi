import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] section = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				int color = Integer.parseInt(st.nextToken());
				section[i][j] = color;
			}
		}
		int[] memo = new int[3];
		for (int i = 0; i < n; i++) {
			memo[1] = 0;
			memo[2] = 0;
			if (section[i][0] != 0) {
				memo[section[i][0]]++;
			}
			for (int j = 1; j < m; j++) {
				int priorColor = section[i][j - 1];
				int color = section[i][j];
				if (color == 0 && Math.max(memo[1], memo[2]) != 0) {
					memo[0] += 1 + Math.min(memo[1], memo[2]);
					memo[1] = 0;
					memo[2] = 0;
				} else if (color != 0 && priorColor != color) {
					memo[color]++;
				}
			}
			if (Math.max(memo[1], memo[2]) != 0)
				memo[0] += 1 + Math.min(memo[1], memo[2]);
		}
		System.out.println(memo[0]);

	}

}