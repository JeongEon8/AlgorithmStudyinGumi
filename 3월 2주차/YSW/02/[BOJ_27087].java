import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			int count = 0;
			if (A % p == 0)
				count++;
			if (B % p == 0)
				count++;
			if (C % p == 0)
				count++;

			sb.append(count >= 2 ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}
}