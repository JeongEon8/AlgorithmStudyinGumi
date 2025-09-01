import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		if ((x > n * 26) || n > x) {
			System.out.println("!");
		} else {
			for (int i = 0; i < n; i++) {
				int tmp = x - (n - i - 1);
				if (tmp >= 26) {
					sb.append("Z");
					x -= 26;
				} else {
					char c = (char) ('A' + tmp - 1);
					sb.append(c);
					x -= tmp;
				}
			}
			System.out.println(sb.reverse());
		}

	}

}