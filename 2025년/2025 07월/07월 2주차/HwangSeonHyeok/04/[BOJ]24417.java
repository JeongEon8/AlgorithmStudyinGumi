import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] f;

	static int fib(int n) {
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
		}

		return f[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		f = new int[n + 1];
		System.out.println(fib(n) + " " + (n - 2));
	}

}