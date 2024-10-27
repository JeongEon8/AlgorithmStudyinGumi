import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static long ans1, ans2, ans3;
	static long absMinPh = Long.MAX_VALUE;
	static long[] liquids;

	static void solution() {
		for (int i = 0; i < n - 2; i++) {
			long p1 = liquids[i];
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				Long ph = p1 + liquids[left] + liquids[right];
				if (ph == 0) {
					ans1 = p1;
					ans2 = liquids[left];
					ans3 = liquids[right];
					return;
				}
				if (Math.abs(ph) < absMinPh) {
					absMinPh = Math.abs(ph);
					ans1 = p1;
					ans2 = liquids[left];
					ans3 = liquids[right];
				}
				if (ph < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		liquids = new long[n];
		for (int i = 0; i < n; i++) {
			liquids[i] = Long.parseLong(split[i]);
		}
		Arrays.sort(liquids);
		solution();
		System.out.println(ans1 + " " + ans2 + " " + ans3);

	}

}