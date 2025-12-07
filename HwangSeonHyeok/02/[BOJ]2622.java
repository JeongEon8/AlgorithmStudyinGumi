import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int ans = 0;
		for (int i = (n + 2) / 3; i < (n + 1) / 2; i++) {
			int maxMid = i;
			int minMid = (n - i + 1) / 2;
			if (maxMid >= minMid) {
				ans += (maxMid - minMid + 1);
			}
		}
		System.out.println(ans);

	}

}