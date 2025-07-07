
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    // D: n을 두배, n > 9999이면, n % 10000
    // S: n - 1, n=0이면 9999
    // L: n의 각 자릿수를 왼편으로 회전
    // R: n의 각 자리수를 오른편으로 회전
    private static int A, B;
    static int[] prev = new int[10000];
    static char[] cmd = new char[10000];
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            String[] split = br.readLine().split(" ");

            A = Integer.parseInt(split[0]); // 초기 값
            B = Integer.parseInt(split[1]); // 최종 값

            visited = new boolean[10000];
            prev = new int[10000];
            cmd = new char[10000];
            convert(A, B);

        }

    }

    public static void convert(int start, int target) {

        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        prev[start] = -1; // 시작점

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            if (curr == target) {
                printPath(target);
                return;
            }

            int[] next = new int[4];
            next[0] = (curr * 2) % 10000;
            next[1] = (curr == 0) ? 9999 : curr - 1;
            next[2] = (curr % 1000) * 10 + (curr / 1000); // 1234 -> 2341
            next[3] = (curr % 10) * 1000 + (curr / 10); // 1234 -> 4123

            char[] op = { 'D', 'S', 'L', 'R' };

            for (int i = 0; i < 4; i++) {

                int nx = next[i];

                if (!visited[nx]) {
                    visited[nx] = true;
                    prev[nx] = curr;
                    cmd[nx] = op[i]; // curr -> nx로 가기 위한 명령어 저장
                    queue.offer(nx);
                }
            }
        }

    }

    public static void printPath(int target) {
        StringBuilder sb = new StringBuilder();

        for (int cur = target; prev[cur] != -1; cur = prev[cur]) {
            sb.append(cmd[cur]);
        }

        System.out.println(sb.reverse().toString());

    }

}
