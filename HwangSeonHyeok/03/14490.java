import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String[] split = str.split(":");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int small = Math.min(a, b);
		for (; small >= 1; small--) {
			if (a % small == 0 && b % small == 0) {
				break;
			}
		}
		System.out.println(a / small + ":" + b / small);
	}

}