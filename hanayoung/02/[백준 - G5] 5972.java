import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] maps = new ArrayList[N];
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            maps[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cnt = Integer.parseInt(st.nextToken());

            maps[start].add(new Node(end, cnt));
            maps[end].add(new Node(start, cnt));
        }

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(0,0));
        visited[0] = true;
        dist[0] = 0;

        while(pQueue.size() > 0) {
            Node cur = pQueue.poll();
            visited[cur.v] = true;
            for(Node node: maps[cur.v]) {
                if(dist[node.v] > dist[cur.v] + node.cost) {
                    dist[node.v] = dist[cur.v] + node.cost;
                    pQueue.add(node);
                }
            }
        }
        System.out.println(dist[N-1]);
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost < o.cost) return -1;
            else return 1;
        }
        
    }
}
