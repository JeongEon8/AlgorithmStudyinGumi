import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][4];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}
		int[] abSum = new int[n * n];
		for (int i = 0; i < n; i++) {
			int a = arr[i][0];
			for (int j = 0; j < n; j++) {
				int b = arr[j][1];
				int sum = a + b;
				abSum[i * n + j] = sum;
			}
		}

		int[] cdSum = new int[n * n];
		for (int i = 0; i < n; i++) {
			int c = arr[i][2];
			for (int j = 0; j < n; j++) {
				int d = arr[j][3];
				int sum = c + d;
				cdSum[i * n + j] = sum;
			}
		}
		long ans = 0;
		Arrays.sort(abSum);
		Arrays.sort(cdSum);
		int abIdx = 0;
		int cdIdx = n * n - 1;
		while (abIdx < n * n && cdIdx >= 0) {
			if (abSum[abIdx] + cdSum[cdIdx] == 0) {
				long abcnt = 1;
				long cdcnt = 1;
				boolean flag = true;
				while (flag) {
					if (abIdx + 1 < n * n && abSum[abIdx + 1] == abSum[abIdx]) {
						abcnt++;
						abIdx++;
					} else {
						flag = false;
					}
				}
				while (!flag) {
					if (cdIdx - 1 >= 0 && cdSum[cdIdx - 1] == cdSum[cdIdx]) {
						cdcnt++;
						cdIdx--;
					} else {
						flag = true;
					}
				}
				ans += abcnt * cdcnt;
				abIdx++;
				cdIdx--;
			} else if (-abSum[abIdx] > cdSum[cdIdx]) {
				abIdx++;
			} else {
				cdIdx--;
			}
		}

		System.out.println(ans);
	}
}