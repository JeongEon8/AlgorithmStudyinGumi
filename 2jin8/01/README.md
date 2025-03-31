# [백준- S1] 1189. 컴백홈
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DFS + BFS

## ⏲️**Time Complexity**
$O(4^K)$

## :round_pushpin: **Logic**
- 완전탐색 + BFS
- 거리가 K일 때만 거리를 계산하기
```java
static void dfs(int dist, int x, int y) {
    if (dist == K) {
        if (x == ex && y == ey) ans++;
        return;
    }

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= R || ny >= C)
            continue;

        // 이미 방문했거나 방문할 수 없는 곳인 경우
        if (visited[nx][ny] || !map[nx][ny])
            continue;

        visited[nx][ny] = true;
        dfs(dist + 1, nx, ny);
        visited[nx][ny] = false;
    }
}
```

## :black_nib: **Review**
문제를 잘 읽자..! 시작점/도착점 멋대로 생각하지 말자

## 📡**Link**
- https://www.acmicpc.net/problem/1189
