import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = -Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i % 3 == 2)
				continue;
			ans -= arr[i];
		}
		System.out.println(ans);
	}
}
