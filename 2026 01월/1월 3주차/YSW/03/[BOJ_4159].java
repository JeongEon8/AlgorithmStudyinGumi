import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4159 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				return;
			}

			int[] map = new int[n];
			for (int i = 0; i < n; i++) {
				map[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(map);

			boolean flag = true;
			int lastPos = 0;
			for (int i = 1; i < n; i++) {
				if (map[i] > lastPos + 200) {
					flag = false;
					break;
				} else {
					lastPos = map[i];
				}
			}

			int distToFinish = 1422 - lastPos;
			if (distToFinish * 2 > 200) {
				flag = false;
			}

			System.out.println(flag ? "POSSIBLE" : "IMPOSSIBLE");
		}

	}
}