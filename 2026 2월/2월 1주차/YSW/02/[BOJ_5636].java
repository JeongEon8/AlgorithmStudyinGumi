import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5636 {
	static boolean[] isPrime = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		precomputePrimes();
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;

			int maxPrime = 0;
			int len = s.length();

			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j <= len && j <= i + 6; j++) {
					String sub = s.substring(i, j);
					int num = Integer.parseInt(sub);

					if (num <= 100000 && isPrime[num]) {
						maxPrime = Math.max(maxPrime, num);
					}
				}
			}
			System.out.println(maxPrime);
		}
	}

	static void precomputePrimes() {
		for (int i = 2; i <= 100000; i++)
			isPrime[i] = true;
		for (int i = 2; i * i <= 100000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 100000; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
}