import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] pies = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pies[i] = Integer.parseInt(st.nextToken());
		}

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += pies[i];
        }

        int max = currentSum;

        for (int i = 0; i < n; i++) {
            currentSum = currentSum + pies[(i + k) % n] - pies[i];
            max = Math.max(max, currentSum);
        }

		System.out.println(max);
	}
}