import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] password = new int[n];
		for (int i = 0; i < n; i++) {
			password[i] = Integer.parseInt(split[i]);
		}
		int[] button = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (button[i] != password[i]) {
				ans++;
				button[i] ^= 1;
				if (i + 1 < n)
					button[i + 1] ^= 1;
				if (i + 2 < n)
					button[i + 2] ^= 1;
			}
		}
		System.out.println(ans);

	}

}