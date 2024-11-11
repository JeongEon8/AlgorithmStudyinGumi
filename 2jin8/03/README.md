# [백준- G5] 5972. 택배 배송
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
최단 거리

## ⏲️**Time Complexity**
$O((V+E)logV)$

## :round_pushpin: **Logic**
- 1부터 N까지 도착하는 최단 거리(주는 여물의 최소 수)를 구하면 됨 => 다익스트라 알고리즘을 사용하기
- 최소 거리를 찾기 위해 우선순위 큐를 사용함
  - 거리 기준 오름차순 정렬하기
```java
static int dijkstra(int x) {
  PriorityQueue<Pos> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.d, p2.d));
  pq.offer(new Pos(x, 0));
  Arrays.fill(minDist, INF);
  minDist[x] = 0;

  while (!pq.isEmpty()) {
    Pos now = pq.poll();

    // 이미 방문했다면 넘어가기
    if (visited[now.x])
      continue;

    visited[now.x] = true;
    if (now.x == N)
      return minDist[N];

    for (Pos next : graph[now.x]) {
      // 현재 통로를 거치는 것이 더 여물을 적게 주는 경우
      if (!visited[next.x] && minDist[next.x] > next.d + minDist[now.x]) {
        minDist[next.x] = next.d + minDist[now.x];
        pq.offer(new Pos(next.x, minDist[next.x]));
      }
    }
  }
  return -1;
}
```

## :black_nib: **Review**
minDist 값을 갱신할 때 `next.d`를 사용해야 하는데 `now.d`를 사용해서 값이 계속 0이 나왔었다. 주의하자..

## 📡**Link**
- https://www.acmicpc.net/problem/5972
