import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int chess[][];
	static int queen;
	static int knight;
	static int pawn;
	static int knightX[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int knightY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int queenX[] = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int queenY[] = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chess = new int[n + 1][m + 1];

		st = new StringTokenizer(br.readLine());
		queen = Integer.parseInt(st.nextToken());
		for (int i = 0; i < queen; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			chess[x][y] = 1;
		}
		st = new StringTokenizer(br.readLine());
		knight = Integer.parseInt(st.nextToken());
		for (int i = 0; i < knight; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			chess[x][y] = 2;
		}
		st = new StringTokenizer(br.readLine());
		pawn = Integer.parseInt(st.nextToken());
		for (int i = 0; i < pawn; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			chess[x][y] = 3;
		}

		queenMove(n, m);
		knightMove(n, m);

		int cnt = 0;

		// 안전한 자리 = 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (chess[i][j] == 0) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		
//		for(int i = 0; i<=n; i++) {
//			for(int j = 0; j<=m; j++) {
//				System.out.print(chess[i][j]+ " ");
//			}
//			System.out.println();
//		}

	}

	private static void knightMove(int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (chess[i][j] == 2) {
					for (int d = 0; d < 8; d++) {
						int nx = i + knightX[d];
						int ny = j + knightY[d];
						if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && chess[nx][ny] == 0) {

							chess[nx][ny] = -1;
						}
					}
				}
			}
		}
	}

	private static void queenMove(int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (chess[i][j] == 1) {
					for (int d = 0; d < 8; d++) {
						int nx = i;
						int ny = j;
						while (true) {
							nx += queenX[d];
							ny += queenY[d];
							if (nx < 1 || ny < 1 || nx > n || ny > m || chess[nx][ny] == 1 || chess[nx][ny] == 2 || chess[nx][ny] == 3)
								break;
							chess[nx][ny] = -1;
						}
					}
				}
			}
		}

	}

}