import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int xorSum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			xorSum = xorSum ^ nums[i];
		}

		int max = xorSum;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, xorSum ^ nums[i]);
		}

		System.out.print(max + "" + max);
	}
}