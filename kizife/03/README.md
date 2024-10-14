# [백준] 7562. 나이트의 이동   
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
bfs  

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. 8개 상대적 좌표에 따른 dx, dy 선언 
```java
    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
```

2. bfs 탐색
```java
        while (!queue.isEmpty()) {
            int[] now = queue.poll();  //현재 좌표를 꺼냄
            int x = now[0];  // 현재 x좌표
            int y = now[1];  // 현재 y좌표

            // 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 체스판 범위 내에 있고, 아직 방문하지 않았다면
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visit[nx][ny]) {
                        queue.add(new int[] { nx, ny });  // 새로운 좌표를 큐에 추가
                        map[nx][ny] = map[x][y] + 1;  // 이동 횟수를 이전 좌표에서 +1
                        visit[nx][ny] = true;  // 방문 표시
                    }
                }
            }
```

3. 목적지의 좌표는 goX, goY이다. bfs 메서드를 통해 map[goX][goY]칸에 이동 횟수가 찍혔을 것이니, 이를 출력한다. 


## :black_nib: **Review**
- 좌표 자체에 +1 하면서 이동 횟수를 찍는 것. 왜 바로 떠오르지 않을까? 

## 📡**Link**
- https://www.acmicpc.net/problem/7562 
