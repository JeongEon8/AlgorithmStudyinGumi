import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {

	static int N, ans;
	static int[] S, W;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		W = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		if (N != 1)
			dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int depth, int cnt) { // cnt: 깨진 계란의 수
		// 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란이면 종료하기
		if (depth == N) {
			if (ans < cnt) ans = cnt;
			return;
		}

		// 현재 계란이 깨져있는 경우거나 깰 수 있는 계란이 없는 경우
		if (S[depth] <= 0 || cnt >= N - 1) {
			dfs(depth + 1, cnt);
			return;
		}

		// 손에 있는 계란으로 다른 계란 중 하나를 한 번 치기
		for (int i = 0; i < N; i++) {
			// 현재 계란을 깨려는 경우 또는 이미 깨진 계란인 경우는 넘어가기
			if (depth == i || S[i] <= 0)
				continue;

			// 다른 계란의 무게만큼 내구도 감소
			S[i] -= W[depth];
			S[depth] -= W[i];

			if (S[i] <= 0 && S[depth] <= 0) { // 계란이 2개 깨진 경우
				dfs(depth + 1, cnt + 2);
			} else if (S[i] <= 0 || S[depth] <= 0) { // 계란이 1개 깨진 경우
				dfs(depth + 1, cnt + 1);
			} else { // 계란이 깨지지 않은 경우
				dfs(depth + 1, cnt);
			}
			
			// 내구도 원복
			S[i] += W[depth];
			S[depth] += W[i];
		}
	}
}
