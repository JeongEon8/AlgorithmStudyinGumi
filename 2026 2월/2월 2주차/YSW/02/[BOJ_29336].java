import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_29336 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] abilities = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			abilities[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(abilities);
		for (int i = 0; i < n / 2; i++) {
			long temp = abilities[i];
			abilities[i] = abilities[n - 1 - i];
			abilities[n - 1 - i] = temp;
		}

		long totalLevel = 0;
		int index = 0;
		long lastDay = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			long day = Long.parseLong(st.nextToken());
			long quality = Long.parseLong(st.nextToken());
			lastDay = day;

			while (totalLevel < quality) {
				if (index >= n) {
					System.out.println(-1);
					return;
				}
				totalLevel += abilities[index] + day;
				index++;
			}
		}

		for (int i = index; i < n; i++) {
			totalLevel += abilities[i] + lastDay;
		}

		System.out.println(totalLevel);
	}
}