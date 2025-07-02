import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String str = in.readLine();
		int[] blossoms = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			blossoms[i] = (str.charAt(i - 1) == 'B') ? blossoms[i - 1] + 1 : blossoms[i - 1];
		}
		int ans = 100001;
		for (int i = 0; i <= n; i++) {
			int flip = (i - blossoms[i]) + (blossoms[n] - blossoms[i]);
			if (ans > flip)
				ans = flip;
		}
		System.out.println(ans);

	}

}