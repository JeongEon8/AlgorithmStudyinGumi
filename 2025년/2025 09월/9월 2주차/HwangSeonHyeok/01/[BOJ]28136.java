import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] table = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		if (table[n - 1] >= table[0])
			ans++;
		for (int i = 1; i < n; i++) {
			if (table[i - 1] >= table[i])
				ans++;
		}
		System.out.println(ans);

	}

}