import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Integer[] length = new Integer[n];
		for (int i = 0; i < n; i++) {
			length[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(length, Collections.reverseOrder());
		int ans = -1;
		for (int i = 0; i < n - 2; i++) {
			if (length[i] < length[i + 1] + length[i + 2]) {
				ans = length[i] + length[i + 1] + length[i + 2];
				break;
			}
		}
		System.out.print(ans);
	}

}