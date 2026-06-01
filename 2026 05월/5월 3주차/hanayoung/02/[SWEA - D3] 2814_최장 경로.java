import java.io.*;
import java.util.*;

class Solution {
    static int max = 0;
    static List<Integer>[] graph;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            init(N);

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int i = 1; i < N+1; i++) {
                visited[i] = true;
                dfs(i,1);
            }
            System.out.println("#"+tc+" "+max);
        }
    }

    static void dfs(int node, int length) {
        max = Math.max(max, length);

        for(int next: graph[node]) {
            if(visited[next] == false) {
                visited[next] = true;
                dfs(next, length+1);
                visited[next] = false;
            }
        }
    }

    static void init(int N) {
        max = 0;
        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N+1];
    }
}
