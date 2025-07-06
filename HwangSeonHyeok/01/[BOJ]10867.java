import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[] nums = new boolean[2010];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		for (String num : split) {
			nums[Integer.parseInt(num) + 1000] = true;
		}
		for (int i = 0; i < 2010; i++) {
			if (nums[i]) {
				sb.append(i - 1000).append(" ");
			}
		}
		System.out.println(sb);

	}

}