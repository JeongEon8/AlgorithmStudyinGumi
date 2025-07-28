
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
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] maps = new ArrayList[N];
        boolean[][] checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            if(maps[i] == null) maps[i] = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if(maps[j] == null) maps[j] = new ArrayList<>();
                    maps[i].add(j);
                }
            }
        }

        int[] path = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken()) -1;
        } 
        ArrayList<Integer>[] visited = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            visited[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for (Integer e : maps[i]) {
                q.add(e);
            }

            while (q.size() > 0) {
                int cur = q.poll();
                if (checked[i][cur] == false) {
                    checked[i][cur] = true;
                    visited[i].add(cur);
                    q.addAll(maps[cur]);
                }
            }
        }
        String answer = "YES";

        for(int i = 0; i < M-1; i++) {
            int cur = path[i];
            if(visited[cur].contains(path[i+1]) == false && cur != path[i+1]) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}
