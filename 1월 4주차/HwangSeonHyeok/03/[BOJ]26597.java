import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long top = (long) 1e18+1;
		long bottom = (long) -1e18-1;
		int ans = 0;
		boolean isAble = true;
		for (int i = 1; i <= n; i++) {
			String[] split = in.readLine().split(" ");
			long x = Long.parseLong(split[0]);
			if (split[1].equals("^") && x > bottom) {
				bottom = x;
			} else if (split[1].equals("v") && x < top) {
				top = x;
			}
			if (ans == 0 && bottom + 2 == top) {
				ans = i;
			} else if (isAble && top <= bottom + 1) {
				ans = i;
				isAble = false;
			}
		}
		if (!isAble) {
			System.out.println("Paradox!");
			System.out.println(ans);
		} else if (ans != 0) {
			System.out.println("I got it!");
			System.out.println(ans);
		} else {
			System.out.println("Hmm...");
		}

	}

}