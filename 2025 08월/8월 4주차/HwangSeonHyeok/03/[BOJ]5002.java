import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine());
		String line = in.readLine();
		int diff = 0;
		int waiting = line.charAt(0) == 'M' ? 1 : -1;
		int ans = 0;
		for (int i = 1; i < line.length(); i++) {
			int current = line.charAt(i) == 'M' ? 1 : -1;
			if (diff > 0) {
				diff += Math.min(waiting, current);
				waiting = Math.max(waiting, current);
			} else {
				diff += Math.max(waiting, current);
				waiting = Math.min(waiting, current);
			}
			if (Math.abs(diff) > x) {
				break;
			} else {
				ans++;
			}
			if (i == line.length() - 1) {
				diff += waiting;
				if (Math.abs(diff) <= x)
					ans++;
			}
		}
		System.out.println(ans);

	}

}