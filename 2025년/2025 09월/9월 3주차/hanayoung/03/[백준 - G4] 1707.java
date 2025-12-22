import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        
        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[V + 1];
            int[] visited = new int[V + 1];
            String answer = "YES";

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (graph[u] == null) {
                    graph[u] = new ArrayList<>();
                }
                if (graph[v] == null) {
                    graph[v] = new ArrayList<>();
                }
                graph[u].add(v);
                graph[v].add(u);
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;
                    while (q.size() > 0) {
                        int cur = q.poll();
                        if (graph[cur] != null) {
                            for (int node : graph[cur]) {
                                if (visited[node] == 0) {
                                    visited[node] = visited[cur] * -1;
                                    q.add(node);
                                } else if (visited[node] == visited[cur]) {
                                    answer = "NO";
                                    q.clear();
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
