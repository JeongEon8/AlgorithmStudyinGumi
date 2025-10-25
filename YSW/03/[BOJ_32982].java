import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_32982 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int K = Integer.parseInt(strArr[1]);
		int[] mealTime = new int[6];
		strArr = br.readLine().split(" ");

		for (int i = 0; i < mealTime.length; i++) {
			mealTime[i] = Integer.parseInt(strArr[i]);
		}

		int currentTime = mealTime[1];
		for (int i = 0; i < N; i++) {
			if (mealTime[2] > currentTime + K) {
				System.out.println("NO");
				return;
			}
			currentTime = Math.min(currentTime + K, mealTime[3]);

			if (mealTime[4] > currentTime + K) {
				System.out.println("NO");
				return;
			}
			currentTime = Math.min(currentTime + K, mealTime[5]);

			if (i < N - 1) {
				if (mealTime[0] > currentTime + K - 1440) {
					System.out.println("NO");
					return;
				}
				currentTime = Math.min(currentTime + K - 1440, mealTime[1]);
			}
		}

		System.out.println("YES");
	}
}
