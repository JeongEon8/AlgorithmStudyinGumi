# [백준 - G5] 2589. 보물섬

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 모든 'L'에 대해 bfs 실행
- 가장 먼 'L'까지의 거리를 구함

```java
for (int i = 0; i < 4; i++) {
    int nx = cx + dx[i];
    int ny = cy + dy[i];

    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && !visited[nx][ny]) {
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny, distance + 1 });
    }
}
```

## :black_nib: **Review**
- bfs..? dfs...?

## 📡**Link**
https://www.acmicpc.net/problem/2589