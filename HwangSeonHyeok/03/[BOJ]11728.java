import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[] A = new int[n];
		int[] B = new int[m];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {

			A[i] = Integer.parseInt(split[i]);
		}
		split = in.readLine().split(" ");
		for (int i = 0; i < m; i++) {

			B[i] = Integer.parseInt(split[i]);
		}
		int aIdx = 0;
		int bIdx = 0;
		while (aIdx < n && bIdx < m) {
			if (A[aIdx] < B[bIdx]) {
				sb.append(A[aIdx++]).append(" ");
			} else {
				sb.append(B[bIdx++]).append(" ");
			}
		}
		while (aIdx < n) {
			sb.append(A[aIdx++]).append(" ");
		}
		while (bIdx < m) {
			sb.append(B[bIdx++]).append(" ");
		}
		System.out.println(sb);
	}

}