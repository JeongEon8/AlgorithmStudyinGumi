import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String password = in.readLine();
		for (int i = 0; i < n - 1; i++) {
			int current = (int) password.charAt(i) - 'A';
			if (current == 0) {
				sb.append('A');
				continue;
			}
			int remain = 26 - current;
			if (k >= remain) {
				k -= remain;
				sb.append('A');
			} else {
				sb.append((char) ('A' + current));
			}
		}
		sb.append((char) ('A' + ((password.charAt(n - 1) - 'A') + k) % 26));
		System.out.println(sb);

	}

}