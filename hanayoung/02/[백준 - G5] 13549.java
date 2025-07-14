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
        int K = Integer.parseInt(st.nextToken());

        final int MIN_POINT = 0;
        final int MAX_POINT = 100000;

        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[MAX_POINT+1];

        visited[N] = 1; // 시작지점이 1

        queue.add(N);

        while (queue.size() > 0) {
            int cur = queue.poll();
            if (cur == K) {
                queue.clear();
                break;
            }

            if ((cur + 1 >= MIN_POINT && cur + 1 <= MAX_POINT) && (visited[cur+1] == 0 || visited[cur + 1] > visited[cur])) {
                queue.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }
            if ((cur - 1 >= MIN_POINT && cur - 1 <= MAX_POINT) && (visited[cur-1] == 0 || visited[cur - 1] > visited[cur])) {
                queue.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
            if ((cur * 2 >= MIN_POINT && cur * 2 <= MAX_POINT) && (visited[cur*2] == 0 || visited[cur*2] > visited[cur])) {
                queue.add(cur*2);
                visited[cur*2] = visited[cur];
            }

        }

        System.out.println(visited[K]-1);
    }
}
