# [백준- G4] 14923. 미로 탈출
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 벽을 최대 1개 부술 수 있음
- 벽을 부순 상태에 따라 방문할 수 있는 곳이 달라짐
- 따라서 방문 배열이 3차원!
  - `[x][y][0]`: 벽 부수지 않은 경우
  - `[x][y][1]`: 벽 부순 경우
```java
while (!queue.isEmpty()) {
  Pos now = queue.poll();
  int x = now.x, y = now.y;
  if (x == Ex && y == Ey)
    return now.d;

  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    if (nx <= 0 || ny <= 0 || nx > N || ny > M || visited[nx][ny][now.crash])
      continue;

    // 현재 칸이 벽인 경우 & 벽을 부술 기회가 남은 경우
    if (map[nx][ny] == 1 && now.crash == 0 && !visited[nx][ny][1]) {
      queue.offer(new Pos(nx, ny, now.d + 1, 1));
      visited[nx][ny][1] = true;
    } 
    // 빈 칸이면 그냥 이동하기
    else if (map[nx][ny] == 0) {
      queue.offer(new Pos(nx, ny, now.d + 1, now.crash));
      visited[nx][ny][now.crash] = true;
    }
  }
}
```

## :black_nib: **Review**
NxM 배열인데 습관적으로 NxN 배열로 사용하지 말자..

## 📡**Link**
- https://www.acmicpc.net/problem/14923
