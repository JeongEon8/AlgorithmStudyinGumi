import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    static class Node {
        int node, weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 간선 정보 수

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] split = br.readLine().split(" ");
            int root = Integer.parseInt(split[0]);
            int child = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);

            graph[root].add(new Node(child, weight));
            graph[child].add(new Node(root, weight));
        }

        for (List<Node> list : graph) {
            Collections.sort(list, (a, b) -> Integer.compare(a.node, b.node));
        }

        visited = new boolean[n + 1];
        tree(1, 0); // 1번 노드에서 가장 먼 노드 찾기

        visited = new boolean[n + 1];
        maxDist = 0;
        tree(farthestNode, 0); // 그 노드에서 다시 DFS

        System.out.println(maxDist); // 트리의 지름

    }

    static boolean[] visited;
    static int farthestNode, maxDist;

    static void tree(int v, int dist) {

        visited[v] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = v;
        }

        for (Node node : graph[v]) {
            if (!visited[node.node]) {
                tree(node.node, dist + node.weight);
            }
        }

    }
}