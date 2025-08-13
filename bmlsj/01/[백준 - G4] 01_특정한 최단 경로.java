
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int N, E;
	private static int[][] dis, weight;
	private static int INF = 200000000;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		E = Integer.parseInt(split[1]);

		dis = new int[N][N];
		weight = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(weight[i], INF);
			weight[i][i] = 0;
		}

		for (int i = 0; i < E; i++) {

			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]) - 1;
			int b = Integer.parseInt(split[1]) - 1;
			int c = Integer.parseInt(split[2]);

			weight[a][b] = c;
			weight[b][a] = c;
		}

		// 무조건 지나야 하는 두 정점
		// 1. 1 -> v1 -> v2 -> N
		// 2. 1 -> v2 -> v1 -> N
		split = br.readLine().split(" ");
		int v1 = Integer.parseInt(split[0]) - 1;
		int v2 = Integer.parseInt(split[1]) - 1;

		// 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dis[i][j] = weight[i][j];
			}
		}

		// 플로이드-워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dis[i][k] != INF && dis[k][j] != INF) {
						dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
					}
				}
			}
		}
		
		long path1 = dis[0][v1] + dis[v1][v2] + dis[v2][N - 1];
		long path2 = dis[0][v2] + dis[v2][v1] + dis[v1][N - 1];

		// System.out.println(path1 + " " + path2);
		if (path1 >= INF || path2 >= INF) {
		    System.out.println(-1);
		} else {
		    System.out.println(Math.min(path1, path2));
		}

	}

}
