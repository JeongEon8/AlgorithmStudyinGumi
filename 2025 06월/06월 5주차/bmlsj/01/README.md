# [백준 - S1] 2468. 안전 영역
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 강수량 높이를 1부터 `max` 값까지 반복해, 각 강수량에 따른 안전 영역의 개수를 찾는다.
- `map[i][j] >= height` 인 지역을 발견하면 DFS를 순회



```java
public static void area(int x, int y, int height) {

    visited[x][y] = true; // 현재 위치 방문 처리

    for (int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 맵 범위를 벗어나는 경우 건너뛰기
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
            continue;
        }

        // 방문하지 않았고, 현재 강수량보다 지형이 높거나 같은 경우에만 이동
        if (!visited[nx][ny] && map[nx][ny] >= height) {
            visited[nx][ny] = true; 
            area(nx, ny, height); 
        }
    }
}
```

## :black_nib: **Review**
- 아무 영역도 잠기지 않았을 때 영역 1개부터 시작할 것


## 📡**Link**
- https://www.acmicpc.net/problem/2468
