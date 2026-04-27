import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] balls = new int[3];
		for (int i = 0; i < 3; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(balls);
		int ans = 0;
		ans += balls[0];
		for (int i = 1; i <= 2; i++) {
			balls[i] -= balls[0];
			ans += balls[i] / 3;
			balls[i] %= 3;
		}
		ans += (balls[1] + balls[2] + 1) / 2;
		System.out.println(ans);

	}

}