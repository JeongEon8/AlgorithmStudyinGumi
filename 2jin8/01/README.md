# [백준 - G4] 17406. 배열 돌리기 4
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색 + 구현

## :round_pushpin: **Logic**
- 회전할 순서를 먼저 고르기
- 대각선을 시작점으로 정한 뒤 회전하기
  - 정사각형을 회전하는 것이므로 `한 변의 길이 / 2`번만 반복하면 됨
```java
static int rotateArr() {
  int[][] arr1 = copyArray(arr);
  int[][] arr2 = copyArray(arr);

  for (int i = 0; i < K; i++) {
    boolean[][] visited = new boolean[N][M];
    Rotate rotate = rotateOrder[i];
    int sr = rotate.r - rotate.s, sc = rotate.c - rotate.s;
    int er = rotate.r + rotate.s, ec = rotate.c + rotate.s;

    // 회전 시작점
    int r = sr, c = sc;
    int end = (er - sr) / 2;
    // (정사각형의 길이 / 2)만큼만 회전하면 됨
    for (int j = 0; j < end; j++) {
      int x = r, y = c, d = 0;
      while (true) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < sr || ny < sc || nx > er || ny > ec || visited[nx][ny]) {
          // 범위 벗어나거나 방문한 곳이면 방향 바꾸기
          if (++d == 4)
            d = 0;
          nx = x + dx[d];
          ny = y + dy[d];
        }

        arr2[nx][ny] = arr1[x][y];
        visited[nx][ny] = true;
        x = nx;
        y = ny;

        // 시작 위치로 돌아오면 종료하기
        if (x == r && y == c)
          break;
      }
      r++;
      c++;
    }
    // 회전을 여러 번 하므로 회전한 배열을 기존 배열로 복사하기
    arr1 = copyArray(arr2);
  }

  int minSum = Integer.MAX_VALUE;
  for (int i = 0; i < N; i++) {
    int sum = 0;
    // 각 행의 합 구하기
    for (int j = 0; j < M; j++) {
      sum += arr2[i][j];
    }
    minSum = Math.min(minSum, sum);
  }
  return minSum;
}
```

## :black_nib: **Review**
쓸데없는 실수로 시간을 많이 날렸다... 문제 조건을 다 정리한 후 풀도록 노력해야지..

## 📡**Link**
- https://www.acmicpc.net/problem/17406
