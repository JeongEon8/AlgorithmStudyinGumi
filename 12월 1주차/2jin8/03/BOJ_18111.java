import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {

	static int N, M, B;
	static int[] heightInfo = new int[257]; // 최대 높이는 256

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int minH = 256, maxH = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, height);
				maxH = Math.max(maxH, height);
				heightInfo[height]++;
			}
		}

		int ansHeight = 0, ansTime = Integer.MAX_VALUE;
		for (int i = minH; i <= maxH; i++) {
			// 쌓아야 하는 블럭의 개수
			int add = 0;
			for (int j = minH; j < i; j++) {
				add += heightInfo[j] * (i - j);
			}

			// 제거해야 하는 블럭의 개수
			int remove = 0;
			for (int j = i + 1; j <= maxH; j++) {
				remove += heightInfo[j] * (j - i);
			}

			// 쌓아야 하는 블럭이 부족하면 다음으로 넘어가기
			if (add > B + remove)
				continue;

			int time = add + remove * 2;
			if (time < ansTime) { // 최소 시간이 걸리는 것 선택하기
				ansTime = time;
				ansHeight = i;
			} else if (time == ansTime) { // 시간이 같으면 높이가 최대인 것 선택하기
				ansHeight = Math.max(ansHeight, i);
			}
		}
		System.out.println(ansTime + " " + ansHeight);
	}
}
