import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point> {
	int x, y, dis, idx;

	Point(int x, int y, int dis, int idx) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.idx = idx;
	}

	@Override
	public int compareTo(Point o) {

		if (this.dis == o.dis) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
		return this.dis - o.dis;
	}

}

public class Main {

	static int N, M, fuel;
	static int[][] map;
	static int startR, startC;
	static int[][] passengers; // [M][4] : sr, sc, er, ec
	static int[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		// N, M, 초기 연료
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		fuel = Integer.parseInt(input[2]);

		// 지도
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 운전 시작 위치(택시 위치)
		input = br.readLine().split(" ");
		startR = Integer.parseInt(input[0]) - 1;
		startC = Integer.parseInt(input[1]) - 1;

		// 승객 정보
		passengers = new int[M][4];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			passengers[i][0] = Integer.parseInt(input[0]) - 1; // 출발 r
			passengers[i][1] = Integer.parseInt(input[1]) - 1; // 출발 c
			passengers[i][2] = Integer.parseInt(input[2]) - 1; // 도착 r
			passengers[i][3] = Integer.parseInt(input[3]) - 1; // 도착 c
		}

		for (int i = 0; i < M; i++) {
			if (!move()) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(fuel);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean move() {

		// 가장 최단 거리 손님 찾기
		Point target = findPassengers();
		if (target == null)
			return false;

		// 택시 이동(연료 양 계산)
		if (fuel < target.dis)
			return false;
		fuel -= target.dis;

		// 승객 id
		int idx = target.idx;

		int dist = bfs(target.x, target.y, passengers[idx][2], passengers[idx][3]);
		if (dist == -1 || fuel < dist)
			return false;

		// 연료 계산
		fuel -= dist;
		fuel += dist * 2;

		startR = passengers[idx][2];
		startC = passengers[idx][3];

		passengers[idx][0] = -1;
		passengers[idx][1] = -1;

		return true;

	}

	static int bfs(int sx, int sy, int tx, int ty) {

		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		q.offer(new int[] { sx, sy, 0 });
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == tx && cur[1] == ty) {
				return cur[2];
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (!visited[nx][ny] && map[nx][ny] == 0) {

					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, cur[2] + 1 });
				}

			}
		}

		return -1;
	}

	static Point findPassengers() {

		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		List<Point> candidates = new ArrayList<>();

		q.offer(new int[] { startR, startC, 0 });
		visited[startR][startC] = true;

		int minDist = Integer.MAX_VALUE;

		while (!q.isEmpty()) {

			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];

			// 이미 최소 거리보다 멀면 탐색 중단
			if (d > minDist)
				break;

			// 현재 위치에 승객 있는지 확인
			for (int i = 0; i < M; i++) {
				if (passengers[i][0] == x && passengers[i][1] == y) {
					candidates.add(new Point(x, y, d, i));
					minDist = d;
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, d + 1 });
				}

			}
		}

		if (candidates.isEmpty())
			return null;

		Collections.sort(candidates);
		return candidates.get(0);
	}

}