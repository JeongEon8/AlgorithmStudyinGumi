import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) {
				sb.append("Case #" + tc + ": INSOMNIA\n");
				continue;
			}
			int see = 0;
			int cnt = 0;
			int find = ((1 << 10) - 1);
			while (see != find) {
				cnt++;
				long tmp = n * cnt;
				while (tmp > 0) {
					see |= 1 << (tmp % 10);
					tmp /= 10;
				}
			}
			sb.append("Case #" + tc + ": " + n * cnt + "\n");
		}
		System.out.println(sb);

	}

}