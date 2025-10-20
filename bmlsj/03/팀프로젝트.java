import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited, finished;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 감지됨
            count++;
            for (int i = next; i != now; i = arr[i]) {
                count++;
            }
        }

        finished[now] = true;
    }
}