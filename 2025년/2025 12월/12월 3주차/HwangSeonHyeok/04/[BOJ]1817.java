import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n == 0) {
			System.out.println(0);

		} else {
			int ans = 1;
			int sum = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				int nextBook = Integer.parseInt(st.nextToken());
				sum += nextBook;
				if (sum > m) {
					ans++;
					sum = nextBook;
				}
			}
			System.out.println(ans);
		}

	}

}