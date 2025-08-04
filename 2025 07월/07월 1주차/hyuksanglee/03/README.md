# [백준- G4] 1504. 특정한 최단 경로
 
## ⏰  **time**
70분

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O(N × M × K)$

## :round_pushpin: **Logic**
- 다익스트라 이용해서 시작점에서 모든점 최단 경로 구하고 걸쳐야하는 두점에서 모든점 최단 경로 구한다.
- 나올수 있는 경우에서 2가지가있다.
  	1. 시작점 -> point1 -> point2 -> 종점
  	2. 시작점 -> point2 -> point1 -> 종점
- 둘중 최소로 나오는 값 출력

```java
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
```

## :black_nib: **Review**
- 다익스트라 오랜만에 푸니깐 어렵네요

## 📡**Link**
- https://www.acmicpc.net/problem/1504
