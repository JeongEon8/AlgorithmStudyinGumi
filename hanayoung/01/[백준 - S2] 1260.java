import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static ArrayList<Integer>[] graph;
    static StringBuilder sbD;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sbB = new StringBuilder();
        sbD = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (graph[start] == null) {
                graph[start] = new ArrayList<>();
            }
            if (graph[end] == null) {
                graph[end] = new ArrayList<>();
            }

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < N + 1; i++) {
            if (graph[i] != null) {
                Collections.sort(graph[i]);
            }
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(V);
        visited[V] = true;

        while (q.size() > 0) {
            int cur = q.poll();
            sbB.append(cur).append(" ");

            if (graph[cur] != null) {
                for (int next : graph[cur]) {
                    if (visited[next] == false) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        visited = new boolean[N + 1];
        visited[V] = true;
        dfs(V, visited);

        System.out.println(sbD);
        System.out.println(sbB);

    }

    static void dfs(int cur, boolean[] visited) {
        sbD.append(cur).append(" ");
        if (graph[cur] == null) {
            return;
        }

        for (int next : graph[cur]) {
            if (visited[next] == false) {
                visited[next] = true;
                dfs(next, visited);
            }
        }
    }
}
