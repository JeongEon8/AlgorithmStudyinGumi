import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] arr = new int[51];
		for (int i = 0; i < n; i++) {
			int time = Integer.parseInt(split[i]) * 2;
			int[] tmpArr = new int[51];
			int tmpTime = time;
			for (int j = 2; j * j <= time; j++) {
				while (tmpTime % j == 0) {
					tmpArr[j]++;
					tmpTime /= j;
				}
			}
			if (tmpTime > 1) {
				tmpArr[tmpTime]++;
			}
			for (int j = 2; j <= 50; j++) {
				arr[j] = Math.max(arr[j], tmpArr[j]);
			}
		}
		long ans = 1;
		for (int i = 2; i <= 50; i++) {
			if (arr[i] > 0) {
				for (int j = 0; j < arr[i]; j++) {
					ans *= i;
				}
			}
		}
		System.out.println(ans);
	}

}