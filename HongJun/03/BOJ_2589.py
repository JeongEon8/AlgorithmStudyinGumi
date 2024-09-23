from collections import deque
import sys
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

r, c = map(int, input().split())
li = []
for i in range(r):
    li.append(list(input()))

graph = [[-1]*c for _ in range(r)]

start = []
for i in range(r):
    for j in range(c):
        if li[i][j] == 'L':
            graph[i][j] = 0
            start.append((i, j))


def bfs(a, b, treasure):
    visit = [[False]*c for _ in range(r)]
    _max = 0
    q = deque()
    q.append((a, b))
    visit[a][b] = True

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < r and 0 <= nx < c:
                if treasure[ny][nx] != -1 and visit[ny][nx] == False:
                    q.append((ny, nx))
                    visit[ny][nx] = True
                    treasure[ny][nx] = treasure[y][x] + 1
    for i in treasure:
        _max = max(_max, max(i))

    return _max

treasure = [[0]*c for _ in range(r)]
result = 0
for a, b in start:
    for i in range(r):
        for j in range(c):
            treasure[i][j] = graph[i][j]
    res = bfs(a, b, treasure)
    result = max(result, res)
print(result)