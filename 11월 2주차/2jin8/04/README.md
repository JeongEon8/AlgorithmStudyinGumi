# [백준- G3] 11779. 최소비용 구하기 2
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
다익스트라 

## ⏲️**Time Complexity**
$O((V+E)logV)$

## :round_pushpin: **Logic**
- 최소 비용을 구하면 되므로 다익스트라(with 우선순위 큐)를 구현하면 됨
- 이때, 최소 비용으로 가는 경로도 기록해야 하므로 경로를 기록하기 위한 배열을 하나 더 사용해야 함
```java
static int dijkstra(int start, int end) {
  PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.d, c2.d));
  pq.offer(new City(start, 0));
  Arrays.fill(minDist, INF);
  minDist[start] = 0;
  route[start] = start;

  while (!pq.isEmpty()) {
    City now = pq.poll();

    if (visited[now.x])
      continue;
    visited[now.x] = true;
    if (now.x == end)
      break;

    for (City next : graph[now.x]) {
      if (!visited[next.x] && minDist[next.x] > next.d + minDist[now.x]) {
        minDist[next.x] = next.d + minDist[now.x];
        pq.offer(new City(next.x, minDist[next.x]));
        route[next.x] = now.x;
      }
    }
  }
  return minDist[end]; // 항상 시작점에서 도착점까지의 경로가 존재함
}
```

## :black_nib: **Review**
예제의 최단 거리와 일치하지 않길래 뭔가 싶었는데 단방향이었다. 너무 당연하게 양방향 그래프라고 생각하고 풀었다.. 제발 문제를 잘 읽자

## 📡**Link**
- https://www.acmicpc.net/problem/11779
