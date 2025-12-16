
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Node>[] graph;

    static class Node implements Comparable<Node> {

        int node, time;

        Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time); // 시간 기준 오름차순
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 컴퓨터 수
            int d = Integer.parseInt(split[1]); // 의존성 개수
            int c = Integer.parseInt(split[2]); // 해킹당한 번호

            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<Node>();
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            PriorityQueue<Node> heap = new PriorityQueue<Node>();
            heap.add(new Node(c, 0));

            for (int i = 0; i < d; i++) {
                split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                int s = Integer.parseInt(split[2]); // s초

                graph[b].add(new Node(a, s)); // b감염 => s초후 a 감염

            }

            while (!heap.isEmpty()) {
                Node curr = heap.poll();
                int time = curr.time;
                int computer = curr.node;

                if (time > dist[computer]) {
                    continue;
                }

                for (Node next : graph[computer]) {
                    int nextTime = time + next.time;
                    if (nextTime < dist[next.node]) {
                        dist[next.node] = nextTime;
                        heap.add(new Node(next.node, nextTime));
                    }
                }
            }

            int cnt = 0, maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            System.out.println(cnt + " " + maxTime);
        }

    }

}
