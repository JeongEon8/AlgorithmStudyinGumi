import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		int ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int start = map[i][j];
				for (int len = 1; i + len < N && j + len < M; len++) {
					if (map[i][j + len] == start && map[i + len][j] == start && map[i + len][j + len] == start) {
						int area = (len + 1) * (len + 1);
						ans = Math.max(ans, area);
					}
				}
			}
		}

		System.out.println(ans);

	}

	static boolean isRange(int i, int j, int idx, int start) {

		if (i + idx >= N || j + idx >= M)
			return false;
		if (map[i][j + idx] == start && map[i + idx][j] == start && map[i + idx][j + idx] == start) {
			return true;
		}

		return true;
	}

}