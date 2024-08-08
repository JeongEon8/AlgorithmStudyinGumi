# [SWEA - 모의 SW 역량테스ㅡ] 1949. 등산로 조성
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DFS + 백트래킹

## :round_pushpin: **Logic**
- 현재 지형보다 낮은 지형으로 이동하는 경우, `방문 처리 → DFS 탐색 → 방문 처리 취소` 과정을 진행하면 됨 (백트래킹)
- 현재 지형보다 높은 지형으로 이동하는 경우, 지형을 깎지 않았으면 이동가능함
  - 등산로 길이가 최대가 되려면 현재 지형과 차이가 적어야 함 (그래야 연결되는 것이 더 많기 때문)
  - 따라서 `현재 지형 - 1`이 되도록 깎기 & 백트래킹 진행
```java
// 현재 지형보다 낮은 지형으로 이동하는 경우
if (map[nx][ny] < map[x][y]) {
    visited[nx][ny] = true;
    dfs(nx, ny, len + 1, isCrash);
    visited[nx][ny] = false;
}
// 낮은 지형에서 높은 지형으로 이동하는 경우 & 지형을 깎지 않은 경우
else if (map[nx][ny] >= map[x][y] && !isCrash) {
    int crash = map[nx][ny] - map[x][y] + 1;
    // 현재 지형과 차이가 적을수록 등산로의 길이가 길어짐
    if (crash <= K) { // 깎는 높이가 K를 넘지 않을 때만 깎기
        map[nx][ny] -= crash;
        visited[nx][ny] = true;
        dfs(nx, ny, len + 1, true);
        visited[nx][ny] = false;
        map[nx][ny] += crash;
    }
}
```

## :black_nib: **Review**
dfs 탐색을 시작하는 위치를 방문처리하지 않아서 삽질했다... 이런 사소한 것들을 놓치지 않도록 주의하자

## 📡**Link**
- [SWEA 1949_등산로 조성](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq)
