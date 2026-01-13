# [백준 - S5] 4108. 지뢰찾기

## ⏰  **time**

30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- BFS를 활용한 문제 풀이

1. 좌표 모두를 돌면서 그 중 방문하지 않았고(`visited`), 지뢰의 수를 표시할 빈 칸(`.`)의 좌표면 `find(i, j)` 함수에 넣는다.
2. `find` 함수에서 기준좌표 `(x, y)`를 기준으로 8방향의 좌표 `(nx, ny)`에 지뢰(`*`)가 있다면, `cnt`에 1을 더한다.
3. for문을 모두 돌면 기준좌표의 지뢰 값을 `visited[x][y]` 에 넣는다.
4. 정답을 출력하면서 기존의 지뢰가 있던 곳은 지뢰로 표현해주고, 빈 칸인 좌표만 `visited` 값을 출력한다.

```java
static int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };

static void find(int x, int y) {

   Queue<int[]> queue = new ArrayDeque<int[]>();
   int cnt = 0;
   queue.offer(new int[] { x, y });

   while (!queue.isEmpty()) {

      int[] curr = queue.poll();
      x = curr[0];
      y = curr[1];

      for (int i = 0; i < 8; i++) {
         int nx = x + dx[i];
         int ny = y + dy[i];

         if (nx < 0 || ny < 0 || nx >= R || ny >= C)
            continue;
         if (visited[nx][ny].equals("0") && map[nx][ny] == '*') {
            cnt++;
         }
      }
      visited[x][y] = cnt + "";
   }
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/4108>
