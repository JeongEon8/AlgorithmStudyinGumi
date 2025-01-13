# [백준 - 골드5] 14503. 로봇청소기기


## ⏰ **time**
50분

## :pushpin: **Algorithm**
구현, DFS

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**

```java
// 방향처리를 위해 백트래킹을 사용했습니다.
for (int i = 0; i < 4; i++) {
    dir = (dir + 3) % 4;
    int nx = x + dx[dir];
    int ny = y + dy[dir];

    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
        clean(nx, ny, dir);
        return;
    }
}

int backDir = (dir + 2) % 4;
int bx = x + dx[backDir];
int by = y + dy[backDir];

if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
    clean(bx, by, dir);
}

```


## :black_nib: **Review**
구현 하는 법을 잊어버려서 오래 걸렸습니다.

## 📡**Link**
https://www.acmicpc.net/problem/14503
