# [백준- G4] 2665. 미로만들기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
최단경로

## ⏲️**Time Complexity**
$O((V+E)logV)$

## :round_pushpin: **Logic**
- 검은 방을 흰 방으로 변경해야 함 & 변경하는 횟수가 최소여야 함
- 시작방에서 끝방까지의 최소 변경 횟수를 구하면 됨
  - 따라서 BFS + 우선순위 큐 or 다익스트라 알고리즘을 사용하면 된다!
- 바꾼 개수를 기준으로 오름차순 정렬해서 변경 횟수가 최소인 것부터 뽑아내기
```java
static int dijkstra(int sx, int sy, int ex, int ey) {
  PriorityQueue<Room> pq = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.d, r2.d));
  pq.offer(new Room(sx, sy, 0));
  minDist[sx][sy] = 0;

  while (!pq.isEmpty()) {
    Room now = pq.poll();
    if (now.x == ex && now.y == ey)
      break;

    if (visited[now.x][now.y])
      continue;
    visited[now.x][now.y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = now.x + dx[i];
      int ny = now.y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N)
        continue;

      if (!visited[nx][ny] && minDist[nx][ny] > minDist[now.x][now.y] + map[nx][ny]) {
        minDist[nx][ny] = minDist[now.x][now.y] + map[nx][ny];
        pq.offer(new Room(nx, ny, minDist[nx][ny]));
      }
    }
  }
  return minDist[ex][ey];
}
```

## :black_nib: **Review**
BFS + 우선순위 큐로도 풀 수 있지만 다익스트라 알고리즘을 익히기 위해 해당 알고리즘을 사용해서 풀었다.

## 📡**Link**
- https://www.acmicpc.net/problem/2665
