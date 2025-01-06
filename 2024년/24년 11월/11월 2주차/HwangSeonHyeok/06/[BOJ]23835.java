import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static class Room {
		int milk;
		List<Integer> secretPass;

		public Room() {
			super();
			this.milk = 0;
			this.secretPass = new ArrayList<Integer>();
		}

	}

	static Room[] rooms;
	static boolean[] visited;

	static boolean delivery(int current, int depth, int destination) {
		visited[current] = true;
		if (current == destination) {
			rooms[current].milk += depth;
			return true;
		}
		for (int next : rooms[current].secretPass) {
			if (visited[next])
				continue;
			if (delivery(next, depth + 1, destination)) {

				rooms[current].milk += depth;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		rooms = new Room[n + 1];
		for (int i = 1; i <= n; i++) {
			rooms[i] = new Room();
		}
		for (int i = 1; i < n; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			rooms[a].secretPass.add(b);
			rooms[b].secretPass.add(a);
		}
		int q = Integer.parseInt(in.readLine());
		for (int i = 0; i < q; i++) {
			String[] split = in.readLine().split(" ");
			int cmd = Integer.parseInt(split[0]);
			if (cmd == 1) {
				int start = Integer.parseInt(split[1]);
				int end = Integer.parseInt(split[2]);
				visited = new boolean[n + 1];
				delivery(start, 0, end);
			} else if (cmd == 2) {
				sb.append(rooms[Integer.parseInt(split[1])].milk + "\n");
			}
		}
		System.out.println(sb);

	}

}