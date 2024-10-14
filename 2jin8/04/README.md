# [백준 - G4] 1504. 특정한 최단 경로
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O((N+E) logN)$

## :round_pushpin: **Logic**
- 무조건 두 지점을 지나서 가야 함
  - `시작 > a > b > 도착`, `시작 > b > a > 도착`의 경우를 고려해야 함
- `시작 > a`, `a > b`, `b > 도착`와 같이 3개로 나눠서 최단 경로를 구해야 함
```java
static int dijkstra(int start, int end) {
  PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
  pq.offer(new Node(start, 0));
  int[] minDist = new int[N + 1];
  boolean[] visited = new boolean[N + 1];
  Arrays.fill(minDist, INF);
  minDist[start] = 0;
  while (!pq.isEmpty()) {
    Node now = pq.poll();

    if (visited[now.u])
      continue;
    visited[now.u] = true;

    if (now.u == end)
      return now.w;

    for (Node next : edges[now.u]) {
      if (!visited[next.u] && minDist[next.u] > minDist[now.u] + next.w) {
        minDist[next.u] = minDist[now.u] + next.w;
        pq.offer(new Node(next.u, minDist[next.u]));
      }
    }
  }
  return -1;
}
```

## :black_nib: **Review**
다익스트라 알고리즘을 까먹어서 다시 개념 공부를 하느라 시간이 많이 걸렸다..

## 📡**Link**
- https://www.acmicpc.net/problem/1504
