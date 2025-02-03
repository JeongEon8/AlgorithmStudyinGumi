import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];  // 최대 100000까지 다룰 수 있도록 설정

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        bfs(N);
        System.out.println(min);
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { start, 0 });
        visited[start] = true;  // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int s = temp[0];
            int t = temp[1];

            // 목적지에 도착했을 때 최소 시간을 갱신하고 종료
            if (s == K) {
                min = t;
                return;
            }

            // s+1 이동, 범위 확인 및 방문 여부 확인
            if (s + 1 <= 100000 && !visited[s + 1]) {
                visited[s + 1] = true;
                queue.offer(new int[] { s + 1, t + 1 });
            }

            // s-1 이동, 범위 확인 및 방문 여부 확인
            if (s - 1 >= 0 && !visited[s - 1]) {
                visited[s - 1] = true;
                queue.offer(new int[] { s - 1, t + 1 });
            }

            // s*2 이동, 범위 확인 및 방문 여부 확인
            if (s * 2 <= 100000 && !visited[s * 2]) {
                visited[s * 2] = true;
                queue.offer(new int[] { s * 2, t + 1 });
            }
        }
    }
}