import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            int[] inDegree = new int[N + 1];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                inDegree[v]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];
            Queue<Integer> q = new ArrayDeque<>();
            for (int j = 1; j <= N; j++) {
                if (inDegree[j] == 0) {
                    dp[j] = time[j];
                    q.offer(j);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == W) break;
                for (int v : graph[u]) {
                    dp[v] = Math.max(dp[v], dp[u] + time[v]);
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        q.offer(v);
                    }
                }
            }

            System.out.println(dp[W]);
        }

    }
}