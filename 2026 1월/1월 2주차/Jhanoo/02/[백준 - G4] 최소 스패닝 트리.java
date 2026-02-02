import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[A].add(new Edge(B, C));
            edges[B].add(new Edge(A, C));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];

        int answer = 0;
        int visitedCount = 1;

        visited[1] = true;
        for (Edge e : edges[1]) {
            pq.offer(e);
        }

        while (!pq.isEmpty() && visitedCount < V) {
            Edge e = pq.poll();
            if (visited[e.v]) continue;

            visited[e.v] = true;
            visitedCount++;
            answer += e.w;

            for (Edge nextEdge : edges[e.v]) {
                if (!visited[nextEdge.v]) {
                    pq.offer(nextEdge);
                }
            }
        }

        System.out.println(answer);
    }
}