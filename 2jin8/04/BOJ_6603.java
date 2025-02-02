import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {

	static int N, M = 6;
	static int[] arr, lotto;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			arr = new int[N];
			lotto = new int[M];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); // 사전 순으로 출력하기 위해 정렬
			makeLotto(0, 0); // 조합 만들기
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 순서 중요 X => 조합
	static void makeLotto(int depth, int start) {
		// 6개를 다 고르면 숫자 조합 완성
		if (depth == M) {
			for (int l : lotto) {
				sb.append(l).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			lotto[depth] = arr[i];
			makeLotto(depth + 1, i + 1);
		}
	}
}
