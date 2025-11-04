# [백준 - S1] 18404. 현명한 나이트 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 격자 그래프

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
나이트의 이동 방향을 bfs로 탐색한다. board에 미방문 칸은 -1 방문칸엔 방문 순번을 넣어 몇번째 방문했는지 구한다.
```java
Queue<Point> q = new ArrayDeque<>();
q.add(new Point(startY, startX));
board[startY][startX] = 0;
while (!q.isEmpty()) {
    Point current = q.poll();
    for (int i = 0; i < 8; i++) {
        int nextY = current.y + dy[i];
        int nextX = current.x + dx[i];
        if (inRange(nextY, nextX) && board[nextY][nextX] == -1) {
            board[nextY][nextX] = board[current.y][current.x] + 1;
            q.add(new Point(nextY, nextX));
        }
    }
}
```
## :black_nib: **Review**
## 📡**Link**
https://www.acmicpc.net/problem/18404