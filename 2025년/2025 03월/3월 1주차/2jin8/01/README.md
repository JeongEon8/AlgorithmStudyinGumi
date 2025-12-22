# [백준- G3] 17142. 연구소 3
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
완전탐색 + BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 활성화 할 바이러스 선택하기 (조합)
- BFS 탐색을 통해 모든 빈 칸이 채워지는 최소 시간 구하기
```java
// 비활성 바이러스 중 M개를 선택해서 활성화 해야 함
static void choiceActiveVirus(int depth, int start) {
  // 순서 상관 X => 조합
  if (depth == M) {
    minTime = Math.min(minTime, bfs());
    return;
  }

  for (int i = start; i < virusList.size(); i++) {
    activeVirusList[depth] = virusList.get(i);

    choiceActiveVirus(depth + 1, i + 1);
  }
}

// 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간 구하기
static int bfs() {
  boolean[][] visited = new boolean[N][N];
  // 활성 바이러스 큐에 넣기
  queue.clear();
  for (Pos activeVirus : activeVirusList) {
    queue.offer(activeVirus);
    visited[activeVirus.x][activeVirus.y] = true;
  }

  int time = 0, fullCount = 0; // 빈 칸을 채운 횟수 세기
  while (!queue.isEmpty()) {
    if (emptyCount == fullCount)
      return time;

    time++;
    int size = queue.size();
    for (int s = 0; s < size; s++) {
      Pos now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
          continue;

        // 이미 방문했거나 벽인 경우
        if (visited[nx][ny] || map[nx][ny] == 1)
          continue;

        // 빈 칸일 경우에만 세기
        if (map[nx][ny] == 0)
          fullCount++;

        queue.offer(new Pos(nx, ny));
        visited[nx][ny] = true;
      }
    }
  }
  return INF;
}
```

## :black_nib: **Review**
문제를 제대로 읽자~

## 📡**Link**
- https://www.acmicpc.net/problem/17142
