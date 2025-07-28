
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Move[] maps = new Move[101]; // 1번부터 100번
        int[] visited = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            maps[from] = new Move(from, to, 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            maps[from] = new Move(from, to, 2);
        }

        for(int i = 1; i < 101; i++) {
            if(maps[i] == null) maps[i] = new Move(i, i, 0);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

        while(q.size() > 0) {
            int cur = q.poll();
            if(cur == 100) break;

            for(int i = 1; i <= 6; i++) {
                int next = cur + i;
                if(next > 100) break;

                if(maps[next].type >= 1 && visited[maps[next].to] == 0) {
                    q.add(maps[next].to);
                    visited[maps[next].to] = visited[cur] + 1;
                } else if(maps[next].type == 0 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
        System.out.println(visited[100]-1);
    }

    static class Move {

        int from;
        int to;
        int type;
        // 아무것도 없음: 0, 사다리: 1, 뱀: 2

        Move(int from, int to, int type) {
            this.from = from;
            this.to = to;
            this.type = type;
        }
    }
}
