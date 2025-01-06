# [백준 - G3️] 23288. 주사위 굴리기 2
 
## ⏰  **time**
거의 4시간..?

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(KNM)$

## :round_pushpin: **Logic**
- 주사위를 이동하는 것은 직접 배열의 값을 변경하면 됨
- 점수는 `주사위가 위치한 배열의 값 * 현재 칸에서 이동 가능한 칸의 수`의 합
  - BFS 탐색을 통해 현재 칸에서 이동 가능한 칸의 수를 구하면 됨
```java
static int getScore(int x, int y) {
  Queue<int[]> queue = new ArrayDeque<>();
  boolean[][] visited = new boolean[N][M];
  queue.offer(new int[] { x, y });
  visited[x][y] = true;
  int cnt = 0, num = map[x][y];
  while (!queue.isEmpty()) {
    int[] now = queue.poll();
    cnt++;

    for (int i = 0; i < 4; i++) {
      int nx = now[0] + dx[i];
      int ny = now[1] + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M)
        continue;

      if (visited[nx][ny] || map[nx][ny] != num)
        continue;

      queue.offer(new int[] { nx, ny });
      visited[nx][ny] = true;
    }
  }
  return map[x][y] * cnt;
}

static int[] moveDice(int x, int y, int d) {
  int nx = x + dx[d];
  int ny = y + dy[d];
  // 이동 방향에 칸이 없다면 이동 방향을 반대로 한 다음 한 칸 굴러가기
  if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
    d = (d + 2) % 4;
    nx = x + dx[d];
    ny = y + dy[d];
  }

  int bottom = dice[6];
  switch (d) {
  case 0: // 동
    dice[6] = dice[3];
    dice[3] = dice[1];
    dice[1] = dice[4];
    dice[4] = bottom;
    break;
  case 1: // 남
    dice[6] = dice[5];
    dice[5] = dice[1];
    dice[1] = dice[2];
    dice[2] = bottom;
    break;
  case 2: // 서
    dice[6] = dice[4];
    dice[4] = dice[1];
    dice[1] = dice[3];
    dice[3] = bottom;
    break;
  case 3: // 북
    dice[6] = dice[2];
    dice[2] = dice[1];
    dice[1] = dice[5];
    dice[5] = bottom;
    break;
  }
  return new int[] { nx, ny, d };
}
```

## :black_nib: **Review**
주사위 굴리기 문제를 이미 풀어서 쉽게 풀 것이라 생각하고 시작했다. 근데 전역 변수 제대로 관리 안하는 등의 여러 실수 때문에 시간을 많이 잡아먹었다.. 
결국 작성한 코드를 다 지우고 변수 사용에 유의하면서 다시 풀었더니 통과됐다... 변수 사용에 주의하자..

## 📡**Link**
- https://www.acmicpc.net/problem/23288
