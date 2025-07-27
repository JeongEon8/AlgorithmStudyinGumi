import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
		int current = (int) -1e9;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int duck = Integer.parseInt(st.nextToken());
			if (duck > current) {
				current = duck + k;
				ans++;
			}
		}
		System.out.println(ans);

	}

}