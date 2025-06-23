import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	private static int T, N;
	private static int[] per, visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String split = br.readLine();

		T = Integer.parseInt(split);

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			per = new int[N + 1];
			visited = new int[N + 1];

			String[] line = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				per[i] = Integer.parseInt(line[i - 1]);
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i] == 0) {
					cnt++;
					cycle(i);
				}
			}

			System.out.println(cnt);
		}

	}

	public static void cycle(int v) {

		visited[v] = 1;

		if (visited[per[v]] == 0) {
			cycle(per[v]);
		}

	}

}