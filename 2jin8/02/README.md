# [백준 - G3️] 17135. 캐슬 디펜스
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 궁수는 젤 아래 행(N번째 행)에만 올 수 있음 & N은 최대 15 ⇒ 완탐(조합) 가능
- 3명의 궁수 위치를 구한 뒤, 적을 제거하는 시뮬레이션을 돌리면 됨
  - 가장 가까이 있는 적 & 거리가 같다면 가장 왼쪽에 있는 적을 죽여야 함 ⇒ BFS 탐색 & 왼쪽 방향부터 탐색하기
```java
static int bfs() {
  int removeCnt = 0;
  int tmpEnemy = enemy;

  Queue<Pos> queue = new ArrayDeque<>();
  int[][] tmpMap = copyArr();
  while (tmpEnemy != 0) {
    Pos[] removeArr = new Pos[3];
    for (int i = 0; i < 3; i++) {
      boolean[][] visited = new boolean[N + 1][M];
      queue.clear();

      int x = N, y = pos[i];
      queue.offer(new Pos(x, y));
      visited[x][y] = true;

      while (!queue.isEmpty()) {
        Pos now = queue.poll();
        // 적이 있는 위치라면 기록하고 탐색 종료하기
        if (tmpMap[now.x][now.y] == 1) {
          removeArr[i] = now;
          break;
        }

        for (int j = 0; j < 3; j++) {
          int nx = now.x + dx[j];
          int ny = now.y + dy[j];
          if (nx < 0 || ny < 0 || nx >= N || ny >= M)
            continue;

          int d = Math.abs(x - nx) + Math.abs(y - ny);
          if (visited[nx][ny] || d > D)
            continue;

          queue.offer(new Pos(nx, ny));
          visited[nx][ny] = true;
        }
      }
    }

    for (Pos p : removeArr) {
      if (p == null || tmpMap[p.x][p.y] == 0)
        continue;

      // 공격받은 적은 게임에서 제외됨
      tmpMap[p.x][p.y] = 0;
      tmpEnemy--; // 남아있는 적의 수 감소
      removeCnt++; // 제거할 수 있는 적의 수 증가
    }

    // 적이 성이 있는 칸으로 이동하면 게임에서 제외됨
    for (int i = 0; i < M; i++) {
      if (tmpMap[N - 1][i] == 1)
        tmpEnemy--;
    }

    // 궁수의 공격이 끝나면 적은 아래로 한 칸 이동함
    for (int i = N - 1; i > 0; i--) {
      tmpMap[i] = tmpMap[i - 1].clone();
    }
    Arrays.fill(tmpMap[0], 0);
  }
  return removeCnt;
}
```

## :black_nib: **Review**
진짜 역대급으로 삽질했던 문제ㅎ 궁수가 위치할 수 있는 곳을 잘못 이해했고, 배열을 복사할 때 순서를 잘못두는 등의 여러 실수를 했다. 다시 또 풀어봐야지 뭐... 

## 📡**Link**
- https://www.acmicpc.net/problem/17135
