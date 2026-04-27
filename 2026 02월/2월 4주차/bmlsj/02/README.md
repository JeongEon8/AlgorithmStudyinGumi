# [백준 - G5] 6593. 상범 빌딩

## ⏰ **time**

40분

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. 시작점 S를 찾아 큐에 (z, x, y, 0)으로 삽입
2. 6방향으로 이동하며, `E`를 만났을 때 `time + 1` 반환
3. 이동 가능한 빈칸(`.`)이면 방문 처리
   - `(nz, nx, ny, time + 1)` 큐에 삽입

```java
static boolean[][][] visited;
static int[] dx = { -1, 1, 0, 0, 0, 0 };
static int[] dy = { 0, 0, -1, 1, 0, 0 };
static int[] dz = { 0, 0, 0, 0, -1, 1 };

static int escape(int z, int x, int y) {

 visited[z][x][y] = true;
 Queue<int[]> queue = new ArrayDeque<>();
 queue.offer(new int[] { z, x, y, 0 });

 while (!queue.isEmpty()) {

  int[] curr = queue.poll();
  z = curr[0];
  x = curr[1];
  y = curr[2];
  int time = curr[3];

  for (int d = 0; d < 6; d++) {
   int nz = z + dz[d];
   int ny = y + dy[d];
   int nx = x + dx[d];

   if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C)
    continue;

   if (visited[nz][nx][ny])
    continue;

   if (map[nz][nx][ny].equals("#"))
    continue;

   if (map[nz][nx][ny].equals("E")) {
    return time + 1;
   }

   if (!visited[nz][nx][ny] && map[nz][nx][ny].equals(".")) {
    visited[nz][nx][ny] = true;
    queue.offer(new int[] { nz, nx, ny, time + 1 });
   }
  }
 }

 return -1;
}
```

## :black_nib: Review

나 왜 골드 풀고 있지..

## 📡**Link**

- [https://www.acmicpc.net/problem/6593](https://www.acmicpc.net/problem/6593)
