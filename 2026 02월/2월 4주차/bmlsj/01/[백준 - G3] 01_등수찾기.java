import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<Integer>[] graph;
	static List<Integer>[] revGraph;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 학생 수
		int M = Integer.parseInt(split[1]); // 질문 수
		int X = Integer.parseInt(split[2]); // 타겟

		graph = new ArrayList[N + 1];
		revGraph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			revGraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);

			graph[a].add(b);
			revGraph[b].add(a);
		}

		visited = new boolean[N + 1];
		count = 0;
		dfs(X);
		int behind = count;

		visited = new boolean[N + 1];
		count = 0;
		reDfs(X);
		int front = count;

		System.out.println((front + 1) + " " + (N - behind));
	}

	static boolean[] visited;
	static int count;

	static void dfs(int cur) {
		visited[cur] = true;
		for (int next : graph[cur]) {
			if (!visited[next]) {
				count++;
				dfs(next);
			}
		}
	}

	static void reDfs(int cur) {
		visited[cur] = true;
		for (int next : revGraph[cur]) {
			if (!visited[next]) {
				count++;
				reDfs(next);
			}
		}
	}

}