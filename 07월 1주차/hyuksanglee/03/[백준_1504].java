package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1504 {
	
	
	
	static int[][] map;
	static int N;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		int[] pointS = new int[N+1];
		int[] point1 = new int[N+1];
		int[] point2 = new int[N+1];
		
		
		
		map = new int[N+1][N+1];
		
		for(int e = 0; e<E; e++) {
			input = in.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int price = Integer.parseInt(input[2]);
			if (map[start][end] == 0 || map[start][end] > price) {
				map[start][end]=price;
				map[end][start]=price;
			}
			
		}
		input = in.readLine().split(" ");
		
		int p1 =Integer.parseInt(input[0]);
		int p2 =Integer.parseInt(input[1]);
		
		pointS = dijkstra(1);
		point1 = dijkstra(p1);
		point2 = dijkstra(p2);
		
		long route1 = (long)pointS[p1] + point1[p2] + point2[N];
        long route2 = (long)pointS[p2] + point2[p1] + point1[N];

        long result = Math.min(route1, route2);
        if(result>= INF) {
        	result = -1;
        }
        System.out.println(result);
		
	}
	
	static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];
            int cost = now[1];

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int next = 1; next <= N; next++) {
                if (map[cur][next] != 0 && !visited[next]) {
                    if (dist[next] > cost + map[cur][next]) {
                        dist[next] = cost + map[cur][next];
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }
        }

        return dist;
    }

}
