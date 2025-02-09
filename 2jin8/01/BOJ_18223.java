import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223 {
    static int V, E, P; // P: 건우가 위치한 정점
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        int dist1 = dijkstra(1, V); // 정점 1에서 V까지의 최단 거리
        int dist2 = dijkstra(1, P) + dijkstra(P, V); // 건우가 위치한 정점을 지나갈 때의 최단 거리
        System.out.println(dist1 < dist2? "GOOD BYE" : "SAVE HIM");
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.d, n2.d));
        int[] minDist = new int[V + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        minDist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // 기록된 최소 거리가 현재 거리보다 작으면 넘어가기
            if (minDist[now.x] < now.d) continue;
            // 도착 지점에 왔으면 종료
            if (now.x == end) break;

            for (Node next : graph[now.x]) {
                if (now.d + next.d < minDist[next.x]) {
                    minDist[next.x] = now.d + next.d;
                    pq.offer(new Node(next.x, minDist[next.x]));
                }
            }
        }
        return minDist[end];
    }

    static class Node {
        int x, d;

        public Node(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }
}
