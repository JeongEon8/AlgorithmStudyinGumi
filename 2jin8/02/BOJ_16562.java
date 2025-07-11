import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16562 {

    static int N, M, K, minCost;
    static int[] friendCosts;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 친구관계 수
        K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        friendCosts = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendCosts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(w);
            graph[w].add(v);
        }

        int totalCost = 0;
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            minCost = Integer.MAX_VALUE;
            dfs(i);
            totalCost += minCost;
        }
        System.out.println(totalCost > K ? "Oh no" : totalCost);
    }

		// 친구의 친구 탐색하기
    static void dfs(int now) {
        minCost = Math.min(minCost, friendCosts[now]); // 최소 비용 갱신
        visited[now] = true;

        for (int next : graph[now]) {
            if (visited[next]) continue;

            dfs(next);
        }
    }
}
