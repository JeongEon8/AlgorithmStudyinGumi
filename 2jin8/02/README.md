# [백준- S3] 26169. 세 번 이내에 사과를 먹자
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
- DFS를 통해서 최대 3번 이동하기
```java
static void dfs(int x, int y, int move, int apple) {
    // 이미 사과를 먹은 경우
    if (isEating) return;

    // 사과 2개 이상 먹고 이동 횟수 남은 경우
    if (apple >= 2 && move <= 3) {
        isEating = true;
        return;
    }

    // 이미 3번 이상 이동한 경우
    if (move == 3) return;

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == -1)
            continue;

        int newApple = map[nx][ny];
        map[nx][ny] = -1;
        dfs(nx, ny, move + 1, apple + newApple);
        map[nx][ny] = newApple;

        if (isEating) return;
    }
}
```

## :black_nib: **Review**
처음에 BFS 썼는데 BFS 쓰면 안되는 문제였다. 잘 생각하자

## 📡**Link**
- https://www.acmicpc.net/problem/26169
