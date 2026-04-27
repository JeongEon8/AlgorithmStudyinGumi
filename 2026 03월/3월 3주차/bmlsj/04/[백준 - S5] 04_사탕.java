import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] boxes = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int R = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				boxes[i] = R * C;
			}

			// 내림차순 정렬
			Arrays.sort(boxes);

			int total = 0;
			int count = 0;

			// 큰 상자부터 사용
			for (int i = N - 1; i >= 0; i--) {
				total += boxes[i];
				count++;

				if (total >= J)
					break;
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}
}