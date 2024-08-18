import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static class Monkey {
		int W, H, k, step;

		public Monkey() {
		}

		public Monkey(int w, int h, int k, int step) {
			W = w;
			H = h;
			this.k = k;
			this.step = step;
		}

	}

	static int[][] map;
	static boolean[][][] visited;
	static int W, H, k;
	static int[] dW = { 1, 0, -1, 0, 2, 2, 1, -1, -2, -2, -1, 1 };
	static int[] dH = { 0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2 };

	static boolean monkeyCheck(int nextW, int nextH) {
		return nextW >= 0 && nextH >= 0 && nextW < W && nextH < H && map[nextH][nextW] == 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(in.readLine());

		String[] split = in.readLine().split(" ");
		W = Integer.parseInt(split[0]);
		H = Integer.parseInt(split[1]);

		map = new int[H][W];
		visited = new boolean[H][W][k + 1];

		for (int i = 0; i < H; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		Queue<Monkey> q = new ArrayDeque<>();
		int destW = W - 1;
		int destH = H - 1;
		int ans = Integer.MAX_VALUE;
		q.add(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Monkey m = q.poll();
			if (m.W == destW && m.H == destH) {
				ans = Math.min(ans, m.step);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nextW = m.W + dW[i];
				int nextH = m.H + dH[i];
				if (monkeyCheck(nextW, nextH) && !visited[nextH][nextW][m.k]) {
					q.add(new Monkey(nextW, nextH, m.k, m.step + 1));
					visited[nextH][nextW][m.k] = true;
				}
			}
			if (m.k < k) {
				for (int i = 4; i < 12; i++) {
					int nextW = m.W + dW[i];
					int nextH = m.H + dH[i];
					if (monkeyCheck(nextW, nextH) && !visited[nextH][nextW][m.k + 1]) {
						q.add(new Monkey(nextW, nextH, m.k + 1, m.step + 1));
						visited[nextH][nextW][m.k + 1] = true;
					}
				}
			}
		}
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}

	}

}