import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_19538 {
	public static ArrayList<Integer>[] graph;
	public static int N;
	public static int[] times;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		times = new int[N + 1];
		Arrays.fill(times, -1);
		queue = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		String[] strArr;

		for (int i = 1; i <= N; i++) {
			strArr = br.readLine().split(" ");
			graph[i] = new ArrayList<Integer>();
			for (int j = 0; j < strArr.length-1; j++) {
				graph[i].add(Integer.parseInt(strArr[j]));
			}
		}

		int startRumar = Integer.parseInt(br.readLine());
		strArr = br.readLine().split(" ");
		for (int i = 0; i < startRumar; i++) {
			queue.add(Integer.parseInt(strArr[i]));
			times[Integer.parseInt(strArr[i])] = 0;
		}

		bfs();
		for (int i = 1; i < times.length; i++) {
			sb.append(times[i] + " ");
		}
		System.out.println(sb.toString());
	}

	public static void bfs() {
		int currentTime = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			currentTime++;
			while (size-- > 0) {
				int currentRumor = queue.poll();

				for (int i = 0; i < graph[currentRumor].size(); i++) {
					int hearer = graph[currentRumor].get(i);
					if (times[hearer] == -1) {
						int cnt = 0;
						for (int j = 0; j < graph[hearer].size(); j++) {
							if (times[graph[hearer].get(j)] < currentTime && times[graph[hearer].get(j)] != -1) {
								cnt++;
							}
						}

						if (cnt * 2 >= graph[hearer].size()) {
							queue.add(hearer);
							times[hearer] = currentTime;
						}
					}
				}
			}
		}
	}
}
