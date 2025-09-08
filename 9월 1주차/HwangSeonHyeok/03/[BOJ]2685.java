import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long nimBSum(long B, long X, long Y) {
		long result = 0;
		long tmp = 1;
		while (X > 0 || Y > 0) {
			long xb = X % B;
			long yb = Y % B;
			long digit = (xb + yb) % B;
			result += tmp * digit;
			X /= B;
			Y /= B;
			tmp *= B;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int B = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			long t = nimBSum(B, X, Y);
			sb.append(t).append("\n");
		}
		System.out.println(sb);

	}

}