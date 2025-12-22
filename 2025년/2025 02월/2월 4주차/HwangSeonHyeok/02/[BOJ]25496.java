import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int p = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[] arr = new int[m];
		split = in.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		int ans = 0;
		int idx = 0;
		while (p < 200 && idx < m) {
			p += arr[idx];
			ans++;
			idx++;
		}
		System.out.println(ans);

	}

}