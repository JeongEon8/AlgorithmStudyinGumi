import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Score {
		int step, s, t;

		public Score(int step, int s, int t) {
			this.step = step;
			this.s = s;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			Queue<Score> que = new ArrayDeque<Score>();
			que.add(new Score(0, s, t));
			while (!que.isEmpty()) {
				Score current = que.poll();
				if (current.s == current.t) {
					sb.append(current.step).append('\n');
					break;
				}
				if (current.s * 2 <= current.t + 3) {
					que.add(new Score(current.step + 1, current.s * 2, current.t + 3));
				}
				que.add(new Score(current.step + 1, current.s + 1, current.t));
			}
		}
		System.out.println(sb);

	}

}