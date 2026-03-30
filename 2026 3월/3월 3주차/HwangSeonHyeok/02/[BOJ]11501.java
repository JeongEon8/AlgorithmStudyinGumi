import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int day = Integer.parseInt(in.readLine());
			int[] prices = new int[day];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < day; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			long benifit = 0;
			int max = 0;
			for (int i = day - 1; i >= 0; i--) {
				max = Math.max(max, prices[i]);
				benifit += max - prices[i];
			}
			sb.append(benifit).append('\n');
		}
		System.out.println(sb);

	}

}