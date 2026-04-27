import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 걷기 = 1칸, 순간이동 = 좌표 * 2
        int[] dist = new int[100_001];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[N] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                System.out.println(dist[x]);
                return;
            }

            int nx = x * 2;
            if (nx <= 100000 && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                q.offerFirst(nx);
            }

            nx = x - 1;
            if (nx >= 0 && nx <= 100000 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                q.offer(nx);
            }

            nx = x + 1;
            if (nx <= 100000 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                q.offer(nx);
            }
        }


    }

}