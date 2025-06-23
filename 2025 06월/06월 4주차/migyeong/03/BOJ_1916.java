import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    static int N, M, S, E;
    static List<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { // 버스 정보
            String[] split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            graph[from].add(new int[]{to, cost});
        }

        String[] split = br.readLine().split(" ");
        S = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);

        dist = new int[N + 1]; // 배열로 최소 비용 관리
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(S);

        System.out.println(dist[E]);
    }

    private static void dijkstra(int start) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // 도시 비용을 기준으로 우선 순위
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int city = temp[0];
            int cost = temp[1];

            if (dist[city] < cost) continue; // 이미 더 짧은 거리로 방문한 경우

            for (int[] next : graph[city]) {
                int nextCity = next[0];
                int nextCost = cost + next[1];

                if(nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.offer(new int[] {nextCity, nextCost});
                }
            }
        }
    }
}
