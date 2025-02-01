import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Test implements Comparable<Test> {
		int x, y;

		public Test(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Test o) {
			return this.x - o.x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int s = Integer.parseInt(split[2]);
		Test[] arr = new Test[n];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			arr[i] = new Test(x, y);
		}
		Arrays.sort(arr);
		int ans = 0;
		if (arr[0].x >= m) {
			System.out.println(0);
		} else {

			for (int i = 1; i < n; i++) {
				if (arr[i].x - (arr[i - 1].x + arr[i - 1].y) >= m) {
					ans = arr[i - 1].x + arr[i - 1].y;
					break;
				}
			}
			if (ans == 0) {
				if (s - (arr[n - 1].x + arr[n - 1].y) >= m) {
					System.out.println(arr[n - 1].x + arr[n - 1].y);
				} else {
					System.out.println(-1);
				}
			} else {
				System.out.println(ans);
			}
		}
	}

}