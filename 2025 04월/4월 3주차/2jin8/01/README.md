# [백준- S1] 18404. 현명한 나이트
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N² + M)$

## :round_pushpin: **Logic**
- 나이트에서 모든 칸까지의 최단 거리 구하기
- 입력받은 말의 위치에 기록된 최단 거리 출력하기
```java
static void bfs() {
    Queue<Horse> queue = new ArrayDeque<>();
    queue.offer(new Horse(sx, sy));
    dist[sx][sy] = 1;
    
    while (!queue.isEmpty()) {
        Horse now = queue.poll();

        for (int i = 0; i < 8; i++) {
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (nx <= 0 || ny <= 0 || nx > N || ny > N || dist[nx][ny] != 0)
                continue;

            queue.offer(new Horse(nx, ny));
            dist[nx][ny] = dist[now.x][now.y] + 1;
        }
    }
}
```

## :black_nib: **Review**
처음에 아무생각없이 하나하나 다 거리 계산하려고 했었음 ㅎ.. (시간초과 생각하자)

## 📡**Link**
- https://www.acmicpc.net/problem/18404
