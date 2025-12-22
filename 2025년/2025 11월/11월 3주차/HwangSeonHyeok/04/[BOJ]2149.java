import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(in.readLine());
			char[] source = in.readLine().toCharArray();
			char[] target = in.readLine().toCharArray();
			int wb = 0;
			int bw = 0;
			for (int i = 0; i < n; i++) {
				if (source[i] == 'W' && target[i] == 'B')
					wb++;
				if (source[i] == 'B' && target[i] == 'W')
					bw++;
			}
			sb.append(Math.max(wb, bw)).append('\n');
		}
		System.out.println(sb);
	}

}