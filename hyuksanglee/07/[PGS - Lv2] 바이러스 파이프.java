import java.util.*;

class Solution {

    static class Edge {
        int next;
        int type;

        Edge(int next, int type) {
            this.next = next;
            this.type = type;
        }
    }

    List<Edge>[] graph;
    int n;
    int k;
    int answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        this.answer = 1;

        // 1. 인접 리스트 생성
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int type = edge[2];

            graph[a].add(new Edge(b, type));
            graph[b].add(new Edge(a, type));
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, 0, infected, 1);

        return answer;
    }

    
    private void dfs(
            int depth,
            int prevType,
            boolean[] infected,
            int count
    ) {

        answer = Math.max(answer, count);

        if (depth == k) {
            return;
        }

        for (int type = 1; type <= 3; type++) {

            if (type == prevType) {
                continue;
            }

            boolean[] nextInfected = infected.clone();

            int nextCount = spread(type, nextInfected, count);

            dfs(
                    depth + 1,
                    type,
                    nextInfected,
                    nextCount
            );
        }
    }

    private int spread(
            int type,
            boolean[] infected,
            int count
    ) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (Edge edge : graph[current]) {

                if (edge.type != type) {
                    continue;
                }
                if (infected[edge.next]) {
                    continue;
                }

                infected[edge.next] = true;
                count++;

                queue.offer(edge.next);
            }
        }

        return count;
    }
}
