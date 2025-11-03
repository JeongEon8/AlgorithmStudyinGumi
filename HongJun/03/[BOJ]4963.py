from collections import deque

dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, -1, 1, 1, -1, 1, -1]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    land[x][y] = 0

    while q:
        a, b = q.popleft()
        for i in range(8):
            nx = a + dx[i]
            ny = b + dy[i]
            if 0 <= nx < h and 0 <= ny < w and land[nx][ny] == 1:
                q.append((nx, ny))
                land[nx][ny] = 0


while 1:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    land = list(list(map(int, input().split())) for _ in range(h))
    count = 0

    for i in range(h):
        for j in range(w):
            if land[i][j] == 1:
                bfs(i, j)
                count += 1
    print(count)