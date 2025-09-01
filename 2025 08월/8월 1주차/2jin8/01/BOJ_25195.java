import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_25195 {

    static int N, M, S;
    static boolean[] edge, gomgom, visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge = new boolean[N + 1];
        gomgom = new boolean[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); // 단방향
        }

        // 간선이 없는 경우 == 더이상 이동할 수 없는 경우
        // 해당 정점 기록
        for (int i = 1; i <= N; i++) {
            if (graph[i].isEmpty()) {
                edge[i] = true;
            }
        }

        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int number = Integer.parseInt(st.nextToken());
            gomgom[number] = true;
        }

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 1
        visited[1] = true;

        // 1번부터 곰곰이가 있으면 무조건 만남
        if (gomgom[1]) {
            return "Yes";
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            // 곰곰이를 만나지 않고 더 이상 이동할 곳이 없는 정점에 도착한 경우
            if (edge[now]) {
                return "yes";
            }

            for (int next : graph[now]) {
                if (!visited[next] && !gomgom[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return "Yes"; // 곰곰이를 만나는 경우
    }
}
