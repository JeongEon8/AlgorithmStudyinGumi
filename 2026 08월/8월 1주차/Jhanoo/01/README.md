# [PGS - Lv2] 01_리코쳇 로봇

## ⏰**time**

37분

## :pushpin: **Algorithm**

- BFS
- 그래프 탐색
- 시뮬레이션
- 2차원 배열

## ⏲️**Time Complexity**

$O(R \times C \times (R + C))$

`R`은 보드의 행 개수이고, `C`는 열 개수이다.

각 정지 위치는 BFS에서 최대 한 번 방문한다.
방문 가능한 위치의 수는 최대 $R \times C$개이다.

각 위치에서는 상하좌우 네 방향으로 이동하며, 한 방향으로 장애물이나 경계를 만날 때까지 최대 $R$칸 또는 $C$칸을 이동한다.

따라서 전체 시간 복잡도는 최악의 경우 다음과 같다.

```text
O(R × C × (R + C))
```

## :round_pushpin: **Logic**

1. 보드 전체를 순회하면서 시작 위치 `R`과 목표 위치 `G`의 좌표를 찾는다.

   ```java
   for (int r = 0; r < rowSize; r++) {
       for (int c = 0; c < colSize; c++) {
           char cell = board[r].charAt(c);
   
           if (cell == 'R') {
               startRow = r;
               startCol = c;
           } else if (cell == 'G') {
               goalRow = r;
               goalCol = c;
           }
       }
   }
   ```

2. 각 위치에 도달하기 위한 최소 이동 횟수를 저장하기 위해 `visited` 배열을 만든다.

   아직 방문하지 않은 위치는 `-1`로 초기화한다.

   ```java
   int[][] visited = new int[rowSize][colSize];
   
   for (int[] row : visited) {
       Arrays.fill(row, -1);
   }
   ```

3. BFS를 시작하기 위해 시작 위치를 큐에 넣고 이동 횟수를 `0`으로 설정한다.

   ```java
   Queue<int[]> q = new ArrayDeque<>();
   
   q.offer(new int[] {startRow, startCol});
   visited[startRow][startCol] = 0;
   ```

4. 상하좌우 네 방향을 방향 배열로 정의한다.

   ```java
   int[] dr = {-1, 1, 0, 0};
   int[] dc = {0, 0, -1, 1};
   ```

5. 큐에서 현재 정지 위치를 하나 꺼낸다.

   현재 위치가 목표 위치라면 해당 위치까지의 최소 이동 횟수를 반환한다.

   ```java
   int[] cur = q.poll();
   int r = cur[0];
   int c = cur[1];
   
   if (r == goalRow && c == goalCol) {
       return visited[r][c];
   }
   ```

6. 현재 위치에서 네 방향으로 각각 이동을 시도한다.

   로봇은 한 칸만 이동하는 것이 아니라, 장애물 `D`나 보드 경계를 만날 때까지 계속 미끄러진다.

   ```java
   for (int d = 0; d < 4; d++) {
       int nextRow = r;
       int nextCol = c;
   
       while (true) {
           int nr = nextRow + dr[d];
           int nc = nextCol + dc[d];
   
           if (
               nr < 0 || nr >= rowSize ||
               nc < 0 || nc >= colSize ||
               board[nr].charAt(nc) == 'D'
           ) {
               break;
           }
   
           nextRow = nr;
           nextCol = nc;
       }
   }
   ```

7. 미끄러진 뒤 멈춘 위치를 이전에 방문했다면 다시 탐색하지 않는다.

   BFS에서는 같은 위치에 처음 도달했을 때의 이동 횟수가 최소이기 때문이다.

   ```java
   if (visited[nextRow][nextCol] != -1) {
       continue;
   }
   ```

8. 처음 방문한 정지 위치라면 현재 이동 횟수에 1을 더해 저장하고 큐에 넣는다.

   ```java
   visited[nextRow][nextCol] = visited[r][c] + 1;
   q.offer(new int[] {nextRow, nextCol});
   ```

9. 큐가 빌 때까지 목표 위치에 도달하지 못했다면 `G`에서 멈출 수 없는 경우이므로 `-1`을 반환한다.

   ```java
   return -1;
   ```

## :black_nib: **Review**

- 각 칸이 아니라 로봇이 실제로 멈출 수 있는 위치를 BFS의 상태로 사용했다.
- `visited` 배열에 최소 이동 횟수를 저장하면 별도로 큐에 이동 횟수를 넣지 않아도 되었다.
- 같은 정지 위치에 다시 도달하더라도 BFS 특성상 처음 방문했을 때가 최소 이동 횟수이므로 재탐색할 필요가 없다.
- 각 위치에서 네 방향으로 끝까지 미끄러지는 시뮬레이션이 포함되므로 시간 복잡도는 단순한 $O(R \times C)$보다 큰 $O(R \times C \times (R + C))$로 볼 수 있다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/169199
