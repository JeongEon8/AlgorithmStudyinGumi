import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1941 {

	static int N = 5, ans;
	static char[][] room;
	static boolean[][] visited;
	static Pos[] pos;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		room = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				room[i][j] = line.charAt(j);
			}
		}
		
		pos = new Pos[7];
		choiceSevenPrincess(0, 0, 0, 0);
		System.out.println(ans);
	}

	// 7명 공주 선택하기 (조합)
	static void choiceSevenPrincess(int depth, int Y, int x, int y) {
		// 임도연파의 수가 4명 이상이면 안됨
		if (Y >= 4)
			return;

		if (depth == 7) {
			// 연결되어 있으면 경우의 수 증가
			if (isConnected())
				ans++;
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = (i == x ? y : 0); j < N; j++) {
				visited[i][j] = true;
				pos[depth] = new Pos(i, j);
				choiceSevenPrincess(depth + 1, Y + (room[i][j] == 'S'? 0 : 1), i, j + 1);
				visited[i][j] = false;
			}
		}
	}

	static boolean isConnected() {
		Queue<Pos> queue = new ArrayDeque<>();
		boolean[][] check = new boolean[N][N];
		queue.offer(pos[0]);
		check[pos[0].x][pos[0].y] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				// 선택한 사람이 아니거나 방문했던 곳이라면 넘어가기
				if (!visited[nx][ny] || check[nx][ny])
					continue;

				queue.offer(new Pos(nx, ny));
				check[nx][ny] = true;
			}
		}
		return cnt == 7;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
