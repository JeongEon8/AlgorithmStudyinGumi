import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		int[] has = new int[n + 1];
		split = in.readLine().split(" ");
		boolean isComplete = true;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(split[i]);
			if (num > n) {
				isComplete = false;
				break;
			}
			has[num]++;

		}
		if (isComplete) {
			for (int i = 1; i <= n; i++) {
				if (has[i] == 0) {
					isComplete = false;
					break;
				} else if (has[i] > 1 && i + k <= n) {
					while (has[i] > 1) {
						has[i]--;
						has[i + k]++;
					}
				}
			}

		}

		if (isComplete) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}