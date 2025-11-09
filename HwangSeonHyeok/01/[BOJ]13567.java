import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int y = 0;
		int x = 0;
		int dir = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String type = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			if (type.equals("MOVE")) {
				int nextY = y + dy[dir] * value;
				int nextX = x + dx[dir] * value;
				if (nextY < 0 || nextX < 0 || nextY > m || nextX > m) {
					System.out.println(-1);
					return;
				}
				y = nextY;
				x = nextX;
			} else {
				if (value == 0) {
					dir = (dir + 1) % 4;
				} else {
					dir = (dir + 3) % 4;
				}
			}
		}
		System.out.println(x + " " + y);

	}

}