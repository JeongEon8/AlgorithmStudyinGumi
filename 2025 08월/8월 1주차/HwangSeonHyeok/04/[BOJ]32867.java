import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] keys = new int[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			keys[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int max = keys[0];
		int min = keys[0];
		for (int i = 1; i < n; i++) {
			int nextKey = keys[i];
			if (nextKey <= max && nextKey >= min)
				continue;
			if (nextKey < min && nextKey > max - k) {
				min = nextKey;
			} else if (nextKey > max && nextKey < min + k) {
				max = nextKey;
			} else {
				ans++;
				max = nextKey;
				min = nextKey;
			}
		}
		System.out.println(ans);

	}

}