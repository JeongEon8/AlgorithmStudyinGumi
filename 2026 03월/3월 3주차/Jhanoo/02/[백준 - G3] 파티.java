import java.io.*;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge> {
        int v;
        int t;

        public Edge(int v, int t) {
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.t, o.t);
        }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        List<Edge>[] reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, t));
            reverseGraph[v].add(new Edge(u, t));
        }

        int[] go = dijkstra(graph, X, N);
        int[] back = dijkstra(reverseGraph, X, N);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, go[i] + back[i]);
        }

        System.out.println(ans);
    }

    static int[] dijkstra(List<Edge>[] graph, int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.t > dist[cur.v])
                continue;

            for (Edge next : graph[cur.v]) {
                if (dist[next.v] > cur.t + next.t) {
                    dist[next.v] = cur.t + next.t;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }
}