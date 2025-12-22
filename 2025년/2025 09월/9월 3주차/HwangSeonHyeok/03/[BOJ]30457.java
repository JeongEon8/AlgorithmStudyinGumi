import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] heights;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		heights = new int[1001];
		for (int i = 0; i < n; i++) {
			int h = Integer.parseInt(st.nextToken());
			heights[h]++;
		}
		int ans = 0;
		for (int h : heights) {
			if (h == 1) {
				ans++;
			} else if (h >= 2) {
				ans += 2;
			}
		}
		System.out.println(ans);
	}

}