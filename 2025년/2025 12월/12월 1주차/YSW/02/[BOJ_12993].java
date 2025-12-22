import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12993 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int x = Integer.parseInt(inputs[0]);
		int y = Integer.parseInt(inputs[1]);
		int[] pow = new int[20];
		pow[0] = 1;
		int limit = 0;

		if (x == 0 && y == 0) {
			System.out.println(1);
			return;
		}

		for (int i = 1; i < 20; i++) {
			pow[i] = pow[i - 1] * 3;
			if (pow[i] > Math.max(x, y)) {
				limit = i - 1;
				break;
			}
		}

		for (int i = limit; i >= 0; i--) {
			if (x > y) {
				x -= pow[i];
			} else {
				y -= pow[i];
			}
		}

		System.out.println((x == 0 && y == 0) ? 1 : 0);
	}
}