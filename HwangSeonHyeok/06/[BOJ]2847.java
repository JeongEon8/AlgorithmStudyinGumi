import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(in.readLine());
		}
		int ans = 0;
		for (int i = n - 2; i >= 0; i--) {
			while (scores[i] >= scores[i + 1]) {
				scores[i]--;
				ans++;
			}
		}
		System.out.println(ans);

	}

}