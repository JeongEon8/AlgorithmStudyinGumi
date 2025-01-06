# [백준 - G5] 9205. 맥주 마시면서 걸어가기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 50미터에 한 병씩 & 20병을 가지고 있을 수 있음 ⇒ 최대 1000미터 이동 가능
- BFS 탐색을 이용해서 도착지까지 도달할 수 있는지 확인하기
  - 이때, 1000미터 이하인 경우에만 이동 가능
```java
static String bfs(int start, int end) {
  Queue<Point> queue = new LinkedList<>();
  queue.offer(points[start]);
  visited[start] = true;

  Point endPoint = points[end];
  while (!queue.isEmpty()) {
    Point now = queue.poll();
    // 페스티벌에 도착한 경우
    if (now.x == endPoint.x && now.y == endPoint.y)
      return "happy";

    for (int i = 1; i < M; i++) {
      Point next = points[i];
      int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
      if (!visited[i] && dist <= 1000) {
        visited[i] = true;
        queue.offer(next);
      }
    }
  }
  return "sad";
}
```

## :black_nib: **Review**
처음에 최단경로 알고리즘을 사용해야 되는줄 알았으나 여러 반례가 존재하고 방문 가능 여부만 확인하면 되므로 BFS 탐색을 사용했다.

## 📡**Link**
- https://www.acmicpc.net/problem/9205
