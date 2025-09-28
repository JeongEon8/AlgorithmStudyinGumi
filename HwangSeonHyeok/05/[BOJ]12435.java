import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] familyInfo = new int[1000001][2];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2 * i; j <= 1000000; j += i) {
				familyInfo[j][0]++;
				if (familyInfo[j][1] == 0) {
					familyInfo[j][1] = i;
				}
			}

		}
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int myBrothers = familyInfo[n][0];
			int ans = 0;
			for (int j = 2; j < n; j++) {
				if (familyInfo[j][0] == myBrothers && familyInfo[j][1] >= m) {
					ans++;
				}
			}
			sb.append("Case #").append(i).append(": ").append(ans).append('\n');
		}
		System.out.println(sb);

	}

}