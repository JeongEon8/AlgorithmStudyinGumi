# [백준 - G4] 14502. 연구소
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
완전 탐색 + BFS

## :round_pushpin: **Logic**
- N, M 범위가 작고 3개의 벽만 세우는 것이므로 완전탐색 가능
- 벽을 세울 위치 3개 선택하기(조합)
- 위치를 모두 정하면 BFS 탐색으로 바이러스 퍼뜨리기
- 바이러스를 다 퍼뜨린 후, 안전 영역의 수 구하기
```java
static void dfs(int depth, int start) {
  // 벽을 세울 3곳을 정한 경우
  if (depth == 3) {
    // 안전 영역의 크기 구하기
    ans = Math.max(ans, bfs());
    return;
  }

  for (int i = start; i < emptyList.size(); i++) {
    Pos now = emptyList.get(i);
    pos[depth] = now;
    map[now.x][now.y] = 1; // 벽 세우기
    dfs(depth + 1, i + 1);
    map[now.x][now.y] = 0; // 벽 치우기
  }
}

static int bfs() {
  Queue<Pos> queue = new ArrayDeque<>();
  visited = new boolean[N][M];
  for (Pos virus : virusList) { // 바이러스 위치 저장하기
    queue.offer(virus);
    visited[virus.x][virus.y] = true;
  }

  int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
  while (!queue.isEmpty()) {
    Pos now = queue.poll();

    for (int i = 0; i < 4; i++) {
      int nx = now.x + dx[i];
      int ny = now.y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M)
        continue;

      // 빈 칸으로 바이러스가 퍼질 수 있을 때
      if (!visited[nx][ny] && map[nx][ny] == 0) {
        queue.offer(new Pos(nx, ny));
        visited[nx][ny] = true;
      }
    }
  }

  // 안전 영역의 수 구하기
  int safeArea = 0;
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      if (map[i][j] == 0 && !visited[i][j]) {
        safeArea++;
      }
    }
  }
  return safeArea;
}
```

## :black_nib: **Review**
N, M의 크기가 작고 벽을 3개만 세우는 것이라 완탐을 사용했다! 

## 📡**Link**
- https://www.acmicpc.net/problem/14502
