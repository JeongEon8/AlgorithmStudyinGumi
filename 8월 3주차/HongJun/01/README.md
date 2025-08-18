# [백준 - S1] 나이트의 이동


## ⏰ **time**
30분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(v+e)

## :round_pushpin: **Logic**
- 나이트는 현재 위치에서 8방향으로 이동할 수 있다.
- 각 이동 좌표 8개를 리스트에 순서대로 넣어준다.
- 나머지는 bfs와 같은 로직으로 구현한다.
```python
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]

    def bfs():
        q = deque()
        q.append([a, b])

        while q:
            x, y = q.popleft()
            if x == c and y == d:
                return position[x][y]

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < l and 0 <= ny < l and position[nx][ny] == 0:
                    position[nx][ny] = position[x][y] + 1
                    q.append([nx, ny])
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/7562
