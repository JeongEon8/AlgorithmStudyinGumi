import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean isUp = true;
		int ans = 1;
		int currentCnt = 0;
		int prev = 0;
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());
			if (prev == current) {
				prev = current;
				ans = Math.max(ans, currentCnt);
				isUp = true;
				currentCnt = 1;
				continue;
			}
			if (isUp) {
				currentCnt++;
				if (prev >= current) {
					isUp = false;
				}

			} else {
				if (prev > current) {
					currentCnt++;
				} else {
					ans = Math.max(ans, currentCnt);
					isUp = true;
					if (prev < current) {
						currentCnt = 2;
					} else {
						currentCnt = 1;
					}
				}
			}
			prev = current;
		}
		ans = Math.max(ans, currentCnt);
		System.out.println(ans);

	}

}