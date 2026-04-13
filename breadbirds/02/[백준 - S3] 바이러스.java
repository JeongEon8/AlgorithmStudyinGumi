import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int node, link;
	static boolean visited[];
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		link = Integer.parseInt(br.readLine());
		visited = new boolean[node + 1];
		// 그래프를 초기화
		for (int i = 0; i <= node; i++) {
			list.add(new ArrayList<>());
		}

		
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(start).add(to);
			list.get(to).add(start);

		}
		bfs(1);
		
		System.out.println(cnt);
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int linkNode : list.get(current)) {
				if (!visited[linkNode]) {
					queue.add(linkNode);
					visited[linkNode] = true;
					cnt++;

				}
			}

		}
		return cnt;

	}

}