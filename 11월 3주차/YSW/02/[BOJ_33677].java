import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_33677 {
	public static class State {
		int day;
		int water;
		int hight;

		public State(int day, int water, int hight) {
			this.day = day;
			this.water = water;
			this.hight = hight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println("0 0");
			return;
		}

		int MAX = N;
		int INF = Integer.MAX_VALUE;

		int[] bestDay = new int[MAX + 1];
		int[] bestWater = new int[MAX + 1];

		Arrays.fill(bestDay, INF);
		Arrays.fill(bestWater, INF);

		Queue<State> queue = new ArrayDeque<>();

		bestDay[N] = 0;
		bestWater[N] = 0;
		queue.add(new State(0, 0, N));

		while (!queue.isEmpty()) {
			State currentState = queue.poll();
			int h = currentState.hight;
			int d = currentState.day;
			int w = currentState.water;

			if (h == 0) {
				System.out.println(d + " " + w);
				return;
			}

			if (h - 1 >= 0) {
				int nh = h - 1;
				int nd = d + 1;
				int nw = w + 1;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}

			if (h % 3 == 0) {
				int nh = h / 3;
				int nd = d + 1;
				int nw = w + 3;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}

			int rt = (int) Math.sqrt(h);
			if (rt * rt == h) {
				int nh = rt;
				int nd = d + 1;
				int nw = w + 5;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}
		}
	}
}

