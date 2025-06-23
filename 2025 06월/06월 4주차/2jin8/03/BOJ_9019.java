import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {

    static final int MAX = 10_000;
    static int A, B;
    static boolean[] visited;
    static int[] numbers = new int[4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[MAX + 1];

            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static String bfs() {
        Queue<Calc> queue = new ArrayDeque<>();
        queue.offer(new Calc("", A));
        visited[A] = true;

        String cmd = "";
        while (!queue.isEmpty()) {
            Calc now = queue.poll();
            if (now.number == B) {
                cmd = now.cmd;
                break;
            }

            int number = now.number;
            int D = (number * 2) % MAX;
            int S = number == 0 ? 9999 : number - 1;
            int L = (number % 1000) * 10 + number / 1000;
            int R = (number % 10) * 1000 + number / 10;

            if (!visited[D]) {
                queue.offer(new Calc(now.cmd + "D", D));
                visited[D] = true;
            }

            if (!visited[S]) {
                queue.offer(new Calc(now.cmd + "S", S));
                visited[S] = true;
            }

            if (!visited[L]) {
                queue.offer(new Calc(now.cmd + "L", L));
                visited[L] = true;
            }

            if (!visited[R]) {
                queue.offer(new Calc(now.cmd + "R", R));
                visited[R] = true;
            }
        }
        return cmd;
    }

    static class Calc {
        String cmd;
        int number;

        public Calc(String cmd, int number) {
            this.cmd = cmd;
            this.number = number;
        }
    }
}
