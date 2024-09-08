# [SWEA - D4] 8382. 방향 전환
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS 탐색

## :round_pushpin: **Logic**
- 첫 이동은 어떤 이동이여도 상관없음 ⇒ 첫 이동이 가로 이동인 경우와 세로 이동인 경우로 나누기
  - 각 경우를 따로 방문처리하기 위해 3차원 배열 사용
- 주어지는 값의 범위가 `-100 ~ 100`이므로 양수로 변환하는 과정 필요
```java
static int bfs(int sx, int sy, int ex, int ey) {
  Queue<Point> queue = new ArrayDeque<>();
  queue.offer(new Point(sx, sy, 0, 0, 0)); // 가로로 시작
  visited[0][sx][sy] = true;
  queue.offer(new Point(sx, sy, 1, 1, 0)); // 세로로 시작
  visited[1][sx][sy] = true;

  while (!queue.isEmpty()) {
    Point now = queue.poll();
    int x = now.x, y = now.y;
    if (x == ex && y == ey) {
      return now.dist;
    }

    if (now.d == 0) { // 가로 이동이었으면 지금은 세로 이동
      for (int i = 0; i < 2; i++) {
        int ny = y + move[i];
        if (ny < 0 || ny > M)
          continue;

        if (!visited[now.start][x][ny]) {
          queue.offer(new Point(x, ny, now.start, 1, now.dist + 1));
          visited[now.start][x][ny] = true;
        }
      }
    } else { // 세로 이동이었으면 지금은 가로 이동
      for (int i = 0; i < 2; i++) {
        int nx = x + move[i];
        if (nx < 0 || nx > M)
          continue;

        if (!visited[now.start][nx][y]) {
          queue.offer(new Point(nx, y, now.start, 0, now.dist + 1));
          visited[now.start][nx][y] = true;
        }
      }
    }
  }
  return -1;
}
```

## :black_nib: **Review**
음수 좌표 문제는 거의 처음 풀어본 것이라 좀 당황했었다ㅎ.. 그래도 다행히 그 외에는 단순 BFS 탐색이라 쉽게 풀 수 있었다.

## 📡**Link**
- https://swexpertacademy.com/main/code/problem/problemDetail.do
