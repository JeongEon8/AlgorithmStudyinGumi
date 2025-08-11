# [백준 - S1] 나이트의 이동


## ⏰ **time**
30분

## :pushpin: **Algorithm**
너비 우선 탐색

## ⏲️**Time Complexity**
O(l^2)

## :round_pushpin: **Logic**
1. bfs로 최소 이동 횟수 계산
2. 큐에 (x, y, 이동횟수) 저장, 시작 위치 방문 표시
3. 현재 위치가 목표 좌표면 이동 횟수 반환
4. 8방향 이동 가능한 좌표 확인 → 범위 내이면서 미방문이면 방문 표시 후 큐에 추가
```java
static int bfs(int nowx, int nowy, int finalx, int finaly) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{nowx, nowy, 0});
    visited[nowx][nowy] = true;

    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int x = cur[0];
        int y = cur[1];
        int count = cur[2];

        if (x == finalx && y == finaly) return count;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }
    }
    return -1;
}
```


## :black_nib: **Review**
그려 

## 📡**Link**
https://www.acmicpc.net/problem/10974
