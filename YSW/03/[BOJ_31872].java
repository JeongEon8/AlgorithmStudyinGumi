import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_31872 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		int[] room = new int[N + 1];
		int[] distance = new int[N];
		inputs = br.readLine().split(" ");
		int result = 0;

		for (int i = 0; i < N; i++) {
			room[i + 1] = Integer.parseInt(inputs[i]);
		}
		Arrays.sort(room);

		for (int i = 0; i < N; i++) {
			distance[i] = room[i + 1] - room[i];
		}
		Arrays.sort(distance);

		for (int i = 0; i < N - K; i++) {
			result += distance[i];
		}

		System.out.println(result);
	}
}