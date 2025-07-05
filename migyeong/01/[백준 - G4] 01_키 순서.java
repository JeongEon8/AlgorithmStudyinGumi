import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int V, E, K;
    static List<int[]>[] list;
    static int[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        V = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);
        K = Integer.parseInt(br.readLine());
        
        // 노드 간 거리 정보를 저장할 배열 초기화
        node = new int[V + 1];
        Arrays.fill(node, Integer.MAX_VALUE);
        node[K] = 0;

        // 인접 리스트 초기화
        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        // 그래프 간선 정보 입력 받기
        for (int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);
            list[u].add(new int[] { v, w });
        }

        // 다익스트라 알고리즘 수행
        dijkstra();

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (node[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(node[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { K, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDist = current[1];

            // 현재 노드까지의 거리가 저장된 거리보다 크면 무시
            if (currDist > node[currNode]) continue;

            // 인접한 노드를 확인하며 최단 거리 갱신
            for (int[] neighbor : list[currNode]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                // 더 짧은 경로 발견 시 업데이트 및 큐에 추가
                if (newDist < node[nextNode]) {
                    node[nextNode] = newDist;
                    pq.offer(new int[] { nextNode, newDist });
                }
            }
        }
    }
}