import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] parent;
    static int[] sub;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }

        parent = new int[N + 1];
        sub = new int[N + 1];

        makeTree(R, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int v = Integer.parseInt(br.readLine());
            sb.append(sub[v]).append("\n");
        }
        System.out.println(sb);
    }

    public static void makeTree(int root, int N) {
        int[] order = new int[N];
        int idx = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        parent[root] = -1;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;

            for (int v : graph[u]) {
                if (v == parent[u]) continue; // v가 u의 부모면 continue
                parent[v] = u;
                stack.push(v);
            }
        }

        for (int i = idx - 1; i >= 0; i--) {
            int u = order[i];
            int size = 1;

            for (int v : graph[u]) {
                if (v == parent[u]) continue;
                if (parent[v] == u) size += sub[v]; // 자식 서브트리에 속한 정점의 수 더하기
            }
            sub[u] = size;
        }

    }
}