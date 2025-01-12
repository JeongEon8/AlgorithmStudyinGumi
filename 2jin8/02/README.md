# [백준- G3] 1941. 소문난 칠공주
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색 + BFS

## ⏲️**Time Complexity**
$O(n^7)$ (n=5)

## :round_pushpin: **Logic**
- 7명은 선택한 후, 선택한 7명이 연결되어 있는지 확인하면 됨
  - 7명 선택 ⇒ 조합
  - 연결되어 있는지 확인 ⇒ BFS
```java
static boolean isConnected() {
  Queue<Pos> queue = new ArrayDeque<>();
  boolean[][] check = new boolean[N][N];
  queue.offer(pos[0]);
  check[pos[0].x][pos[0].y] = true;

  int cnt = 0;
  while (!queue.isEmpty()) {
    Pos now = queue.poll();
    cnt++;

    for (int i = 0; i < 4; i++) {
      int nx = now.x + dx[i];
      int ny = now.y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N)
        continue;

      // 선택한 사람이 아니거나 방문했던 곳이라면 넘어가기
      if (!visited[nx][ny] || check[nx][ny])
        continue;

      queue.offer(new Pos(nx, ny));
      check[nx][ny] = true;
    }
  }
  return cnt == 7;
}
```

## :black_nib: **Review**
2차원 배열의 조합을 만들 때 헷갈렸다. 이 문제는 5x5라서 1차원 배열로 풀어서 했어도 가능했음 생각을 유연하게 하도록..

## 📡**Link**
- https://www.acmicpc.net/problem/1941
