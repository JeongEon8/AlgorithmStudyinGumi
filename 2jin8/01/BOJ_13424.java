import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13424 {

	static final int INF = 1_000_000_000;
	static int N, M, K;
	static int[] people, dist[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dist = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			}

			// 비밀 통로 거리 정보 저장
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[a][b] = c;
				dist[b][a] = c;
			}

			// 출발지 -> 도착지 거리 구하기
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) { // 출발
					for (int j = 1; j <= N; j++) { // 도착
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}

			// 모임에 참여하는 친구들
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			people = new int[K];
			for (int i = 0; i < K; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}

			int minTotal = INF, minIdx = 0;
			for (int i = 1; i <= N; i++) {
				int total = 0;
				for (int person : people) {
					total += dist[person][i];
				}

				if (minTotal > total) {
					minTotal = total;
					minIdx = i;
				}
			}
			sb.append(minIdx).append("\n");
		}
		System.out.println(sb);
	}
}
