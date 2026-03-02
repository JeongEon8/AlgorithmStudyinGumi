import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25633 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dominoWeights = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			dominoWeights[i] = Integer.parseInt(st.nextToken());
		}

		int maxDominoes = 1;
		for (int i = 0; i < n - 1; i++) {
			int currentWeight = dominoWeights[i];
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (currentWeight >= dominoWeights[j]) {
					currentWeight += dominoWeights[j];
					count++;
				}
			}
			if (maxDominoes < count) {
				maxDominoes = count;
			}
		}

		System.out.println(maxDominoes);
	}
}