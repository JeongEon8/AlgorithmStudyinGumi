import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int A, B, C;

        public Edge(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(C, o.C);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2 ~ 100,000
        int M = Integer.parseInt(st.nextToken()); // 1 ~ 1,000,000

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(A, B, C);
        }
        Arrays.sort(edges);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        long sum = 0;
        int maxC = 0;
        int cnt = 0;

        for (Edge edge : edges) {
            int rootA = UnionFind(edge.A);
            int rootB = UnionFind(edge.B);

            if (rootA == rootB) continue;

            parent[rootA] = rootB;
            sum += edge.C;
            maxC = Math.max(maxC, edge.C);
            cnt++;

            if (cnt == N - 1) break;
        }

        System.out.println(sum - maxC);
    }

    static int UnionFind(int x) {
        if (parent[x] == x) return x;
        return parent[x] = UnionFind(parent[x]);
    }
}