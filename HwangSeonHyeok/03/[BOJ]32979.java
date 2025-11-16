import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int t = Integer.parseInt(in.readLine());
		int[] hands = new int[n * 2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n * 2; i++) {
			hands[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		int handCnt = 2 * n;
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(st.nextToken());
			idx = (idx + num - 1) % handCnt;
			sb.append(hands[idx]).append(' ');
		}
		System.out.println(sb);
	}

}