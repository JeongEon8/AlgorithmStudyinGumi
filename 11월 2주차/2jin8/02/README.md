# [백준- G5] 2660. 회장뽑기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 회원의 점수는 모든 친구들을 탐색하는 최소 거리(횟수)를 뜻함
  - 회원의 점수가 1점 = 어느 회원이 다른 모든 회원과 친구
  - 회원의 점수가 2점 = 어느 회원이 다른 모든 회원과 친구 or 친구의 친구
  - 회원의 점수가 3점 = 어느 회원이 다른 모든 회원과 친구 or 친구의 친구 or 친구의 친구의 친구
  - …
- 따라서 각 회원에서 BFS 탐색을 수행하여 모든 회원을 탐색하는 최소 거리를 구해야 함
  - 탐색이 끝날 때마다 모든 회원을 탐색하는 최소 거리 중 최소값을 찾아야 함
      - 만약 현재 최소값보다 작다면 최소값을 갱신하기
      - 같다면 리스트에 넣기
```java
static int bfs(int x) {
  Queue<Integer> queue = new ArrayDeque<>();
  queue.offer(x);
  dist[x] = 1; // 방문 처리를 위해 1로 표시 (원래 0)

  int max = 0;
  while (!queue.isEmpty()) {
    int now = queue.poll();
    max = Math.max(max, dist[now]); // 모두 연결되어 있으니 여기서 최댓값 찾기

    for (int next : graph[now]) {
      if (dist[next] == 0) {
        queue.offer(next);
        dist[next] = dist[now] + 1;
      }
    }
  }
  return max - 1; // 처음 위치에 1을 더해줬으니 최종값은 1을 빼야 함
}
```

## :black_nib: **Review**
문제가 어려워보였지만, 잘 읽어보면 그냥 BFS로 최단 거리를 찾는 문제라는 것을 알 수 있었다.

## 📡**Link**
- https://www.acmicpc.net/problem/2660
