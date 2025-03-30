import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int ans = 0;
		int totalmax = 0;
		for (int people = 1; people <= n; people++) {
			String[] split = in.readLine().split(" ");
			int[] card = new int[5];
			for (int i = 0; i < 5; i++) {
				card[i] = Integer.parseInt(split[i]);
			}
			int max = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					for (int k = j + 1; k < 5; k++) {
						int sum = (card[i] + card[j] + card[k]) % 10;
						max = Math.max(max, sum);
					}
				}
			}
			if (max >= totalmax) {
				totalmax = max;
				ans = people;
			}
		}
		System.out.println(ans);

	}

}
