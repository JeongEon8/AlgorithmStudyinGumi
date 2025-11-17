import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N + 1];
        int[][] usado = new int[N + 1][N + 1];
        List<Integer>[] given = new ArrayList[N+1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(given[p] == null) given[p] = new ArrayList<>();
            given[p].add(q);
            if(given[q] == null) given[q] = new ArrayList<>();
            given[q].add(p);
            usado[p][q] = r;
            usado[q][p] = r;
        }
        // 해당 동영상을 기준으로 판단한 게 있는지 확인하고, 있으면 가져와서 출력하기
        // 동영상 p와 동영상 q 간의 USADO를 int[][] 로 저장
        // 초기값은 0인거고

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (check[v] == false) {
                // given에 붙은 리스트를 돌면서 usado에서 꺼내서 비교하기.? 
                // 큐에 넣어서 쭉쭉 이어서 가야하려나? 
                for(int m: given[v]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{m, usado[v][m]}); // 다음 노드와 그 사이의 최소 usado
                    boolean[] visited = new boolean[N+1];
                    visited[m] = true;
                    while(q.size() > 0) {
                        int[] cur = q.poll();
                        for(int n: given[cur[0]]) {
                            if(visited[n] == false && v != n) {
                                int min = Math.min(cur[1], usado[cur[0]][n]);
                                usado[v][n] = min;
                                usado[n][v] = usado[v][n];
                                visited[n] = true;
                                q.add(new int[]{n, min});
                            }
                        }
                    }
                }
            }
            int answer = 0;

            for(int j = 1; j < N+1; j++) {
                if(usado[v][j] >= k && v != j) answer++;
            }
            check[v] = true;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

