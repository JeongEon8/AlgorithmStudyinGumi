# [백준 - G1] 1194. 달이 차오른다, 가자
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
BFS + 비트마스킹

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 가진 열쇠의 종류에 따라 방문 체크를 다르게 해야 함
  - 3차원 방문 배열 사용 ⇒ `visited[x][y][가진 열쇠의 종류]`
```java
static int bfs(int sx, int sy) {
  Queue<Point> queue = new ArrayDeque<>();
  queue.offer(new Point(sx, sy, 0, 0));
  visited[sx][sy][0] = true;

  while (!queue.isEmpty()) {
    Point now = queue.poll();
    int x = now.x, y = now.y, dist = now.dist;
    if (map[x][y] == '1') { // 출구에 도착
      return dist;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M)
        continue;

      if (map[nx][ny] == '#' || visited[nx][ny][now.key])
        continue;

      char next = map[nx][ny];
      // 열쇠가 있는 경우
      if (next >= 'a' && next <= 'f') {
        int key = next - 'a';
        // 해당 열쇠를 이미 획득한 경우, 그냥 방문하기
        if ((now.key & (1 << key)) > 0) {
          queue.offer(new Point(nx, ny, now.key, dist + 1));
          visited[nx][ny][now.key] = true;
        }
        // 해당 열쇠를 획득한 적이 없는 경우
        else {
          int newKey = now.key | (1 << key); // 열쇠 획득
          if (!visited[nx][ny][newKey]) {
            queue.offer(new Point(nx, ny, newKey, dist + 1));
            visited[nx][ny][newKey] = true;
          }
        }
      }
      // 문이 있는 경우
      else if (next >= 'A' && next <= 'F') {
        int door = next - 'A';
        // 문을 열 수 있는 열쇠가 있는 경우
        if ((now.key & (1 << door)) > 0) {
          queue.offer(new Point(nx, ny, now.key, dist + 1));
          visited[nx][ny][now.key] = true;
        }
      }
      // 빈 칸 or 시작 위치 or 출구인 경우
      else {
        queue.offer(new Point(nx, ny, now.key, dist + 1));
        visited[nx][ny][now.key] = true;
      }
    }
  }
  return -1;
}
```

## :black_nib: **Review**
처음에 가진 열쇠의 개수에 따라 방문 배열을 작성했는데 그렇게 하면 반례가 많이 생기는 것을 뒤늦게 알았다.. 잘 생각하고 문제를 풀자

## 📡**Link**
- https://www.acmicpc.net/problem/1194
