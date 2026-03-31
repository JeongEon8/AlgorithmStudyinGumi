import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_15804 {
	public static class BusInfo {
		int arriveTime;
		int departTime;
		int busStopIndex;

		public BusInfo(int arriveTime, int stopTime, int busStopIndex) {
			this.arriveTime = arriveTime;
			this.departTime = stopTime;
			this.busStopIndex = busStopIndex;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayDeque<BusInfo> queue = new ArrayDeque<>();

		int lastIdx = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int arriveTime = Integer.parseInt(st.nextToken());
			int stopTime = Integer.parseInt(st.nextToken());
			while (!queue.isEmpty()) {
				if (queue.peekFirst().departTime <= arriveTime) {
					queue.pollFirst();
				} else {
					break;
				}
			}

			if (queue.isEmpty()) {
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, 1));
			} else if (queue.peekLast().busStopIndex == n) {
				while (!queue.isEmpty()) {
					arriveTime = Math.max(arriveTime, queue.peekFirst().departTime);
					queue.pollFirst();
				}
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, 1));
			} else {
				arriveTime = Math.max(arriveTime, queue.peekLast().arriveTime);
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, queue.peekLast().busStopIndex + 1));
			}

			if (i == m - 1) {
				lastIdx = queue.peekLast().busStopIndex;
			}
		}

		System.out.println(lastIdx);
	}
}