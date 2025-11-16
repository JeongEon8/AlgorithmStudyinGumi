import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 0;
		while (true) {
			if (sum > S) {
				break;
			}
			sum += ++count;
		}

		System.out.println(count - 1);
	}
}
