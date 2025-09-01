# [백준 - S2] 18126. 너구리 구구

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 트리
- 너비 우선 탐색
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
모든 방으로 이동이 가능한데 길은 n-1개이므로 트리 구조이다.  
트리 구조를 탐색하면 처음 도착하는게 해당 방까지의 최단거리가 보장되므로 bfs로 탐색하고 가장 거리가 먼 방의 거리를 찾는다.
```java
Queue<Integer> q = new ArrayDeque<>();
long[] dist = new long[n + 1];
boolean[] visit = new boolean[n + 1];
q.add(1);
visit[1] = true;
while (!q.isEmpty()) {
    int current = q.poll();
    for (Edge e : list[current]) {
        int next = e.dest;
        if (!visit[next]) {
            dist[next] = dist[current] + e.dist;
            visit[next] = true;
            q.add(next);

        }
    }
}
long ans = 0;
for (int i = 0; i <= n; i++) {
    ans = Math.max(ans, dist[i]);
}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/18126
