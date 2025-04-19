# [백준 - 골드 5] 17070. 파이프 옮기기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(3^{2N})$

## :round_pushpin: **Logic**
1. 3가지 경우에 대해 파이프의 방향을 정해줌
```java
// 3가지 이동 방향에 대해 검사
for (int i = 0; i < 3; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
        // 가로 파이프일 때는 세로로 이동 불가
        if (type == 2 && i == 1)
            continue;
        // 세로 파이프일 때는 가로로 이동 불가
        if (type == 3 && i == 0)
            continue;

        // 대각선으로 이동할 때는 세 칸이 모두 비어 있어야 함
        if (i == 2 && (map[x + 1][y] != 0 || map[x][y + 1] != 0))
            continue;

        // 다음 상태로 재귀 호출
        dfs(nx, ny, i + 2); // i + 2는 파이프의 새로운 상태를 의미
    }
}
```

## :black_nib: **Review**
- 알고리즘... 너 뭐 돼? 다음엔 dp로 풀어보는 걸로..

## 📡 Link
https://www.acmicpc.net/problem/17070
