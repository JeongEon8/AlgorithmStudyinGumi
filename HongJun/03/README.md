# [백준 - G4] 2665. 알고스팟

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 0-1 BFS

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

- BFS처럼 4방향으로 이동한다.
- 다음 이동이 가중치가 0인 곳이면 덱의 앞 부분에 넣는다.
- 가중치가 1인 곳이면 덱의 맨 뒤에 넣는다.

```python
def bfs(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = 0

    while q:
        y, x = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=ny<m and 0<=nx<n and visited[ny][nx] == -1:
                # 벽이 없음 -> 덱의 앞 부분에 위치 추가
                if miro[ny][nx] == 0:
                    q.appendleft((ny, nx))
                    visited[ny][nx] = visited[y][x]

                # 벽이 있음 -> 덱의 끝에 추가
                else:
                    q.append((ny, nx))
                    visited[ny][nx] = visited[y][x] + 1
```

## :black_nib: **Review**
가중치가 0, 1만 있는거면 0-1너비우선 탐색이구나

## 📡**Link**

https://www.acmicpc.net/problem/1261