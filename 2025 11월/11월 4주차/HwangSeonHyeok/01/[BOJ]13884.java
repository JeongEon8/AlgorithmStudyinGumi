import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] numbers = new int[n];
			for (int idx = 0; idx < n;) {
				st = new StringTokenizer(in.readLine());
				while (st.hasMoreTokens()) {
					numbers[idx++] = Integer.parseInt(st.nextToken());
				}
			}
			int[] sortedNumbers = Arrays.copyOf(numbers, n);
			Arrays.sort(sortedNumbers);
			int matchingIdx = 0;
			for (int i = 0; i < n; i++) {
				if (numbers[i] == sortedNumbers[matchingIdx]) {
					matchingIdx++;
				}
			}
			sb.append(k).append(" ").append(n - matchingIdx).append("\n");
		}
		System.out.println(sb);
	}

}