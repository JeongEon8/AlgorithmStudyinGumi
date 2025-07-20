# [백준 - S4] 1388. 바닥 장식

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 그래프 이론
- 그래프 탐색
- 격자 그래프

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
타일을 bfs로 탐색하여 타일 갯수를 구한다.  
-인경우 오른쪽으로 |인 경우 아래로 탐색한다.
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
            ans++;
            visited[i][j] = true;
            if (tiles[i][j]) {
                int y = i + 1;
                while (y < n && tiles[y][j]) {
                    visited[y][j] = true;
                    y++;
                }
            } else {
                int x = j + 1;
                while (x < m && !tiles[i][x]) {
                    visited[i][x] = true;
                    x++;
                }
            }
        }
    }
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1388