import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21937 {

    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 역방향으로 연결하기
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int target = Integer.parseInt(br.readLine());
        System.out.println(bfs(target));
    }

    static int bfs(int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target);
        visited[target] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;

            for (int next : graph[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return count - 1;
    }
}
