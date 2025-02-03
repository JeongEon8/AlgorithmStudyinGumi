# [백준- S2] 17086. 아기 상어 2
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²M²)$

## :round_pushpin: **Logic**
- 상어가 없는 칸에서 상어가 있는 칸까지의 최단 거리를 구하면 됨
- 이때, 최단 거리가 가장 큰 것을 출력하면 됨
```java
while (!queue.isEmpty()) {
  int[] now = queue.poll();
  int x = now[0], y = now[1];
  if (dist[x][y] != 1 && map[x][y] == 1) {
    safeDist = dist[x][y] - 1;
    break;
  }

  for (int i = 0; i < 8; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    if (nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] != 0)
      continue;

    queue.offer(new int[] { nx, ny });
    dist[nx][ny] = dist[x][y] + 1;
  }
}
```

## :black_nib: **Review**
각 상어끼리의 최대 거리라고 잘못 이해했었다ㅎ.. 그리고 오랜만에 8방향이라 dx, dy 순간 까먹음

## 📡**Link**
- https://www.acmicpc.net/problem/17086
