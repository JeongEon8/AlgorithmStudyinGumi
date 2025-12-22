import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_22993 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		long myAtk = Long.parseLong(inputs[0]);
		int[] playerAtk = new int[N];

		for (int i = 1; i < N; i++) {
			playerAtk[i] = Integer.parseInt(inputs[i]);
		}

		Arrays.sort(playerAtk);

		for (int i = 1; i < N; i++) {
			if (myAtk > playerAtk[i]) {
				myAtk += playerAtk[i];
			} else {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}
}