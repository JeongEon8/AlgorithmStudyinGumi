import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (r == 0 && c == 0)
				break;
			int[][] mine = new int[r][c];
			for (int i = 0; i < r; i++) {
				String str = in.readLine();
				for (int j = 0; j < c; j++) {
					char point = str.charAt(j);
					if (point == '*') {
						mine[i][j] = -1;
						for (int k = 0; k < 8; k++) {
							int nextR = i + dx[k];
							int nextC = j + dy[k];
							if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c && mine[nextR][nextC] != -1) {
								mine[nextR][nextC]++;
							}
						}
					}

				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (mine[i][j] == -1) {
						sb.append('*');
					} else {
						sb.append(mine[i][j]);
					}
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);

	}

}