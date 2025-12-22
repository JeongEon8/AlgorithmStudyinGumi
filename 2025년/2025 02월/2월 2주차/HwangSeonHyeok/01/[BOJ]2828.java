import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int j = Integer.parseInt(in.readLine());
		int current = m;
		int ans = 0;
		for (int i = 0; i < j; i++) {
			int apple = Integer.parseInt(in.readLine());
			if (current - m >= apple) {
				ans += current - m - apple + 1;
				current = m + apple - 1;
			} else if (apple > current) {
				ans += apple - current;
				current = apple;
			}
		}
		System.out.println(ans);
	}

}