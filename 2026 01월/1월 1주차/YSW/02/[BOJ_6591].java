import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_6591 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] inputs = br.readLine().split(" ");
			int n = Integer.parseInt(inputs[0]);
			int k = Integer.parseInt(inputs[1]);
			k = Math.min(k, n - k);

			if (n == 0) {
				break;
			}

			long combinationCount = 1;
			for (int i = 0; i < k; i++) {
				combinationCount = combinationCount * (n - i) / (i + 1);
			}

			sb.append(combinationCount).append("\n");

		}
		System.out.println(sb.toString());
	}
}