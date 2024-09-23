import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long[] fact = new long[16];
		long tmp = 1;
		for (int i = 1; i <= 15; i++) {
			tmp *= i;
			fact[i] = tmp;
		}
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int a = Integer.parseInt(split[1]);
		int b = Integer.parseInt(split[2]);
		int c = Integer.parseInt(split[3]);
		long ans = fact[n] / fact[a] / fact[b] / fact[c];
		System.out.println(ans);
	}

}