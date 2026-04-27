import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int waitTime(int current, int green, int red) {
		int cycle = green + red;
		int t = current / cycle;
		int prevTime = cycle * t;
		if (prevTime + green > current) {
			return 0;
		} else {
			return prevTime + cycle - current;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] signal = new int[n];
		int[] bridge = new int[n];
		int[] green = new int[n];
		int[] red = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			signal[i] = Integer.parseInt(st.nextToken());
			bridge[i] = Integer.parseInt(st.nextToken());
			green[i] = Integer.parseInt(st.nextToken());
			red[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int totalSignalTime = signal[i] + waitTime(ans, green[i], red[i]);
			if (totalSignalTime > bridge[i]) {
				ans += bridge[i];
			} else {
				ans += totalSignalTime;
			}
		}
		System.out.println(ans);

	}

}