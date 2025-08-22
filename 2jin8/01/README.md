# [백준- S3] 17484. 진우의 달 여행 (Small)
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완탐

## ⏲️**Time Complexity**
$O(M · 2^N)$

## :round_pushpin: **Logic**
- `depth`를 행 위치라고 생각하고, 각 열마다 이동할 방향 선택해서 다음 행으로 넘기기
- 이때 시작 지점이 M개 (`[0][0]` ~ `[0][M-1]`)이므로 dfs 탐색을 총 M번 호출해야 함
```java
static void move(int depth, int y, int dir, int total) {
    if (depth == N) {
        answer = Math.min(answer, total);
        return;
    }

    // 이동가능한 모든 방향으로 이동
    for (int d = -1; d <= 1; d++) {
        // 이전이랑 같은 방향으로 이동 X
        if (d == dir) continue;

        int ny = y + d;
        // 범위 벗어나면 X
        if (ny < 0 || ny >= M) continue;

        move(depth + 1, ny, d, total + cost[depth][y]);
    }
}
```

## :black_nib: **Review**
DP로도 풀 수 있는 것 같다. 찾아봐야지

## 📡**Link**
- https://www.acmicpc.net/problem/17484
