import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2090 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];

		long mul = 1;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			mul *= nums[i];
		}

		for (int i = 0; i < N; i++) {
			sum += mul / nums[i];
		}

		long gcd = gcd(sum, mul);

		System.out.println((mul / gcd) + "/" + (sum / gcd));
	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}