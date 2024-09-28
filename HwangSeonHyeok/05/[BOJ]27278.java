import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		int[] distSum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			distSum[i + 1] = distSum[i] + Integer.parseInt(split[i]);
		}
		int cycle = distSum[n];
		int ans = 0;
		for (int j = 0; j < m; j++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]) - 1;
			int to = Integer.parseInt(split[1]) - 1;
			int start = Integer.parseInt(split[2]);
			int rideTime, goalTime;
			if (start % cycle > distSum[from]) {
				rideTime = (start / cycle + 1) * cycle + distSum[from];
			} else {
				rideTime = (start / cycle) * cycle + distSum[from];
			}
			if (from < to) {
				goalTime = rideTime + distSum[to] - distSum[from];
			} else {
				goalTime = rideTime + cycle - distSum[from] + distSum[to];
			}
			if (goalTime > ans) {
				ans = goalTime;
			}
		}
		System.out.println(ans);

	}

}