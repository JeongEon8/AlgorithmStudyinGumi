import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_16928 {
    static int[][] L, S;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[] check = new boolean[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 사다리 수
        int M = Integer.parseInt(split[1]); // 뱀의 수

        L = new int[N][2];
        S = new int[M][2];

        // 사다리의 위치
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            L[i][0] = Integer.parseInt(split[0]); // 사다리 위치
            L[i][1] = Integer.parseInt(split[1]); // 사디리 이동 위치
        }

        // 뱀의 위치
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            S[i][0] = Integer.parseInt(split[0]); // 뱀 위치
            S[i][1] = Integer.parseInt(split[1]); // 뱀 이동 위치
        }

        int result = bfs(); // 플레이어 시작 위치

        System.out.println(result);
    }

    private static int bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0}); // 시작칸 1, 이동횟수 0

        check[1] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int pos = temp[0];
            int cnt = temp[1];

            if (pos == 100) return cnt;

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100 || check[next]) continue;

                int moved = move(next);
                if (!check[moved]) {
                    check[moved] = true;
                    queue.offer(new int[]{moved, cnt + 1});
                }
            }

        }
        return -1;
    }

    private static int move(int next) {
        for (int[] ladder : L) {
            if (ladder[0] == next) return ladder[1];
        }
        for (int[] snake : S) {
            if (snake[0] == next) return snake[1];
        }
        return next;
    }
}
