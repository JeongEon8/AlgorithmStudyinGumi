import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = i;
			while (tmp > 0) {
				if (tmp % 10 == d) {
					ans++;
				}
				tmp /= 10;
			}
		}
		System.out.println(ans);

	}

}