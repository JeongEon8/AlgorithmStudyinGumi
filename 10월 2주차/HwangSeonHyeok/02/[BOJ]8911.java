import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			int dir = 0;
			int maxY = 0;
			int minY = 0;
			int maxX = 0;
			int minX = 0;
			int x = 0;
			int y = 0;
			String cmds = in.readLine();
			for (int j = 0; j < cmds.length(); j++) {
				switch (cmds.charAt(j)) {
					case 'F': {
						x += dx[dir];
						y += dy[dir];
						break;
					}
					case 'B': {
						x -= dx[dir];
						y -= dy[dir];
						break;
					}
					case 'L': {
						dir = (dir + 3) % 4;
						break;
					}
					case 'R': {
						dir = (dir + 1) % 4;
						break;
					}
				}
				maxY = Math.max(maxY, y);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				minX = Math.min(minX, x);
			}
			sb.append((maxY - minY) * (maxX - minX) + "\n");

		}
		System.out.println(sb);

	}
}