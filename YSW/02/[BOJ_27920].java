import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_27920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N + 1];

		int index = 1;
		int index2 = 0;
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				if (i % 2 == 1) {
					numbers[index] = N;
				} else {
					numbers[N - index2] = N;
				}
			} else if (i % 2 == 1) {
				numbers[index++] = N - i;
			} else {
				numbers[N - index2++] = N - i;
			}
		}
		sb.append("YES\n");

		for (int i = 1; i < numbers.length; i++) {
			sb.append(numbers[i] + " ");
		}
		sb.append("\n");

		index = 1;
		index2 = 0;
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				if (i % 2 == 1) {
					sb.append(index);
				} else {
					sb.append(N - index2);
				}
			} else if (i % 2 == 1) {
				sb.append(index++ + " ");
			} else {
				sb.append(N - index2++ + " ");
			}
		}

		System.out.println(sb.toString());
	}
}