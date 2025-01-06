import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] xor;

	static int q1(int x, int y) {
		return xor[x] ^ xor[y];
	}

	static int q2(int x, int y, int d) {
		return xor[x] ^ xor[y] ^ d;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int q = Integer.parseInt(split[1]);
		xor = new int[n + 2];
		split = in.readLine().split(" ");
		for (int i = 0; i < n - 1; i++) {
			xor[i + 2] = xor[i + 1] ^ Integer.parseInt(split[i]);
		}

		for (int i = 0; i < q; i++) {
			split = in.readLine().split(" ");
			int cmd = Integer.parseInt(split[0]);
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			if (cmd == 0) {
				sb.append(q1(x, y) + "\n");
			} else if (cmd == 1) {
				int d = Integer.parseInt(split[3]);
				sb.append(q2(x, y, d) + "\n");
			}
		}

		System.out.println(sb);

	}

}