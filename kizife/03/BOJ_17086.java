import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6 {

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int result = 0;
//	static int length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
//		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					result = Math.max(bfs(i, j), result); //리턴되는 거리들 중 최댓값 저장
				}
			}
		}
		System.out.println(result);
	}

	private static int bfs(int x, int y) {

		visit = new boolean[n][m]; // 매 좌표마다 bfs 돌리므로, visit배열 새로 선언
		visit[x][y] = true;

		Queue<int[]> queue = new LinkedList<>(); // 큐 선언
		queue.add(new int[] { x, y, 0 }); // 시작 좌표 x, y, 거리 저장

		while (!queue.isEmpty()) { // 큐가 비어있지 않다면 탐색 계속함
			int[] now = queue.poll(); // 큐에서 첫 번째 요소 꺼냄

			for (int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i]; // 다음 x좌표
				int ny = now[1] + dy[i]; // 다음 y좌표
				int length = now[2] + 1; // 현재까지의 거리+1

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) { // 배열 범위 내에 있다면
					if (map[nx][ny] == 1) { // 새로운 좌표에 1이 있다면, 목표에 도달한 것!
						return length; // 그러므로 거리 반환
					}

					queue.offer(new int[] { nx, ny, length }); // 새로운 좌표에 1이 없다면, 아직 목표ㄴㄴ. 새로운 좌표, 거리 저장해줌
					visit[nx][ny] = true; // 새로운 좌표 방문처리
				}

			}

		}

		return 0;
	}
}
