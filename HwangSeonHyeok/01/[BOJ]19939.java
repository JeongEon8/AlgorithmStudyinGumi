import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		int minimum = k * (k + 1) / 2;
		if (n >= minimum) {
			if ((n - minimum) % k == 0) {
				System.out.println(k - 1);
			} else {
				System.out.println(k);
			}
		} else {
			System.out.println(-1);
		}
	}

}
