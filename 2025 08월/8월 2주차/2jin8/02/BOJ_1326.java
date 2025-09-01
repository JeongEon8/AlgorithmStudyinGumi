import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1326 {

    static int N, A, B;
    static int[] jump, dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jump = new int[N + 1];
        dist = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(A);
        dist[A] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == B) {
                return dist[B] - 1;
            }

            // 징검다리에 적힌 수의 배수만큼 떨어진 곳으로 갈 수 있음
            // 앞으로 이동
            for (int i = 1; i <= N; i++) {
                int move = now + jump[now] * i;
                if (move > N) break;

                if (dist[move] == 0) {
                    queue.offer(move);
                    dist[move] = dist[now] + 1;
                }
            }

            // 뒤로 이동
            for (int i = 1; i <= N; i++) {
                int move = now - jump[now] * i;
                if (move <= 0) break;

                if (dist[move] == 0) {
                    queue.offer(move);
                    dist[move] = dist[now] + 1;
                }
            }
        }
        return -1;
    }
}
