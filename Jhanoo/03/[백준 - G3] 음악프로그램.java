import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int u = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                inDegree[v]++;
                u = v;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            sb.append(u).append("\n");

            for (int v : graph[u]) {
                if (--inDegree[v] == 0) q.offer(v);
            }
        }

        if (cnt < N) System.out.println(0);
        else System.out.print(sb);
    }
}