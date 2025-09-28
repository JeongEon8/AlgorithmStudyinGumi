# [백준- G5] 27211. 도넛 행성
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- BFS 탐색하기
- 다음 좌표가 범위를 벗어난다면 위치 조정하기
  - `nx < 0` -> `nx = N - 1`, `nx >= N` -> `nx = 0`
  - `ny < 0` -> `ny = M - 1`, `ny >= M` -> `ny = 0`
```java
static void bfs(int x, int y) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
        int[] now = queue.poll();

        for (int i = 0; i < 4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];

            // 연결되어 있으므로 범위 벗어나도 좌표 옮겨주기
            if (nx < 0) nx = N - 1;
            if (ny < 0) ny = M - 1;
            if (nx >= N) nx = 0;
            if (ny >= M) ny = 0;

            if (!visited[nx][ny] && map[nx][ny] == 0) {
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
```

## :black_nib: **Review**
좌표 옮겨줄 때 N, M 헷갈림 주의..!

## 📡**Link**
- https://www.acmicpc.net/problem/27211
