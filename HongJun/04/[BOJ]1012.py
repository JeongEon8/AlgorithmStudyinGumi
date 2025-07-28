from collections import deque

t = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


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


for _ in range(t):
    m, n, k = map(int, input().split())

    arr = [[0 for _ in range(n)] for _ in range(m)]
    count = 0

    for i in range(k):
        a, b = map(int, input().split())
        arr[a][b] = 1

    for i in range(m):
        for j in range(n):
            if arr[i][j] == 1:
                bfs(i, j)
                count += 1
    print(count)