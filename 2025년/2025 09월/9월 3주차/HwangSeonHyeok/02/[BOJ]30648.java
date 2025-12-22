import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(in.readLine());
		boolean[][] flowers = new boolean[r][r];
		flowers[a][b] = true;
		int ans = 0;
		while (true) {
			ans++;
			if (a + b + 2 < r) {
				a++;
				b++;
			} else {
				a /= 2;
				b /= 2;
			}
			if (flowers[a][b])
				break;
			flowers[a][b] = true;
		}
		System.out.println(ans);

	}

}