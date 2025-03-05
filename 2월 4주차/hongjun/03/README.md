# [백준 - G3] 2206. 벽 부수고 이동하기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 3차원 배열을 사용한 BFS를 적용해야함.
2. [y좌표][x좌표][벽을 부순 횟수]
3. 다음 위치에 벽이 없는 경우엔 그냥 이동
4. 벽이 있는 경우 -> 벽을 부순 횟수가 0이어야 한 번 깰 수 있음

```python
def bfs():
    dq = deque()
    dq.append((0, 0, 0))  # y좌표, x좌표, 벽 부순 횟수
    visited[0][0][0] = 1    # 방문 처리

    while dq:
        # break_wall = 벽을 부순 횟수
        y, x, break_wall = dq.popleft()

        # 끝에 도달하면 거리 리턴
        if y == n-1 and x == m-1:
            return visited[y][x][break_wall]
    
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
    
            if 0 <= ny < n and 0 <= nx < m:
                # 다음 위치에 벽이 없는 경우엔 그냥 이동
                if graph[ny][nx] == 0 and visited[ny][nx][break_wall] == 0:
                    visited[ny][nx][break_wall] = visited[y][x][break_wall]+1
                    dq.append((ny, nx, break_wall))
    
                # 벽이 있는 경우 -> 벽을 부순 횟수가 0이어야 한 번 깰 수 있음
                if graph[ny][nx] == 1 and break_wall == 0 and visited[ny][nx][1] == 0:
                    # 다음 위치는 벽을 1번 부쉈음
                    visited[ny][nx][1] = visited[y][x][break_wall] + 1
                    dq.append((ny, nx, 1))
    return -1
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/2206