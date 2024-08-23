# [백준 - 골5] 16926. 배열 돌리기 1
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- `(1, 1)`, `(2, 2)`, ... 각 대각선을 시작점으로 잡고 회전 시작
- 회전하려는 칸이 범위를 벗어나거나 이미 회전한 곳이면 회전 방향을 변경하기
```java
static void rotateArr(int start) {

  int x = start, y = start, d = 0; // d: 이동 방향
  while (true) {
    int nx = x + dx[d];
    int ny = y + dy[d];
    // 범위를 벗어나거나 이미 방문한 지점으로 이동하려는 경우, 회전 방향을 변경하기
    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
      if (d == 3) d = 0;
      else d++;
      nx = x + dx[d];
      ny = y + dy[d];
    }

    visited[nx][ny] = true;
    newArr[nx][ny] = arr[x][y];
    x = nx;
    y = ny;

    if (x == start && y == start)
      break;
  }
}
```

## :black_nib: **Review**
N과 M이 달라서 당황했었지만, 둘 중 하나는 무조건 짝수로 주어지기 때문에 대각선을 시작점으로 잡았다. 이런 순수 구현 문제가 익숙하지 않아서 많이 풀어봐야 할 것 같다.

## 📡**Link**
- [백준 16926_배열 돌리기 1](https://www.acmicpc.net/problem/16926)
