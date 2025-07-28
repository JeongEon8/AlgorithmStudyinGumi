# [백준- S2] 1012. 유기농 배추
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- BFS 다시 익히기
  
```python
def bfs(x, y):
    arr[x][y] = 0
    que = deque()
    que.append((x, y))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 밭 밖으로 인덱스가 넘어가면 continue
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if arr[nx][ny] == 1:
                arr[nx][ny] = 0
                que.append((nx, ny)) 
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1012
