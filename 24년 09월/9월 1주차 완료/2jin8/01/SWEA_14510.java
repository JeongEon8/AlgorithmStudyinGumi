import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] trees = new int[n];
			st = new StringTokenizer(br.readLine());

			int maxH = 0; // 나무의 최대 높이
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, trees[i]);
			}

			// 1의 개수 = 홀수날 물을 줘야하는 횟수
			// 2의 개수 = 짝수날 물을 줘야하는 횟수
			int oneCnt = 0, twoCnt = 0;
			for (int tree : trees) {
				// 최대 높이와의 차이 구하기
				int diff = maxH - tree;
				if (diff == 0) // 최대 높이면 넘어가기
					continue;

				// 1의 개수, 2의 개수 구하기
				oneCnt += diff % 2; // 1의 개수
				twoCnt += diff / 2; // 2의 개수
			}

			// 최소 일수를 구하기 위해 1의 개수와 2의 개수 균형 맞추기
			if (oneCnt < twoCnt) { // 2일 = 1일 + 1일로 쪼갤 수 있음
				// 최소 일수가 되려면 1의 개수와 2의 개수의 차이가 1이여야 함
				while (Math.abs(oneCnt - twoCnt) > 1) {
					twoCnt--;
					oneCnt += 2;
				}
			}

			// 1의 개수가 더 크면
			int ans = 0;
			// 둘의 개수가 같다면 최소 일수는 "1의 개수 + 2의 개수"
			if (oneCnt == twoCnt) { // ex) 1 2 1 2
				ans = oneCnt + twoCnt;
			}
			// 1의 개수가 더 크다면 최소 일수는 "1의 개수 * 2 - 1"
			else if (oneCnt > twoCnt) { // ex) 1 2 1 2 1
				ans = oneCnt * 2 - 1;
			}
			// 2의 개수가 더 크다면 최소 일수는 "2의 개수 * 2"
			else { // ex) 1 2 1 2 _ 2
				ans = twoCnt * 2;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
