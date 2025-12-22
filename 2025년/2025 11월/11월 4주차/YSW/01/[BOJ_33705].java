import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_33705 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] voteOneCount = new int[N + 1];
		String[] inputs = br.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			int vote = Integer.parseInt(inputs[i - 1]);
			voteOneCount[i] = voteOneCount[i - 1] + (vote == 1 ? 1 : 0);
		}

		int result;
		if (voteOneCount[N] * 2 >= N) {
			result = 0;
		} else {
			result = 2;
			for (int i = 1; i <= N; i++) {
				if (voteOneCount[i] * 2 >= i || (voteOneCount[N] - voteOneCount[N - i]) * 2 >= i) {
					result = 1;
					break;
				}
			}
		}

		System.out.println(result);
	}
}