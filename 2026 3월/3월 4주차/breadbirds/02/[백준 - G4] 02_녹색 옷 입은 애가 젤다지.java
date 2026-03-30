import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int minMoney[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break; // 입력 종료 조건

			arr = new int[N][N];
			minMoney = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = dijkstra(0, 0);
			System.out.println("Problem " + tc + ": " + answer);
			tc++;
		}
	}

	private static int dijkstra(int y, int x) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((old, newArr) -> old[2] - newArr[2]);
		queue.add(new int[] { y, x, arr[y][x] });

		for (int i = 0; i < N; i++) {
			Arrays.fill(minMoney[i], Integer.MAX_VALUE);
		}
		minMoney[y][x] = arr[y][x];

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int py = current[0];
			int px = current[1];
			int money = current[2];

			if (py == N - 1 && px == N - 1) {
				return money;
			}

			for (int i = 0; i < 4; i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}

				int newMoney = money + arr[ny][nx];
				
				if (newMoney < minMoney[ny][nx]) {
					minMoney[ny][nx] = newMoney;
					queue.add(new int[] { ny, nx, newMoney });
				}
			}
		}
		return -1;
	}
}