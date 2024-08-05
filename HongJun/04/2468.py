from collections import deque


N = int(input())
region = []
for _ in range(N):
    region.append(list(map(int, input().split())))
_max = max(map(max, region))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

cnt_li = []


def bfs(x, y, town):
    town[x][y] = 1
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < N:
                if town[nx][ny] == 0:
                    town[nx][ny] = 1
                    q.append((nx, ny))

for water in range(_max):
    li = [[0 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if region[i][j] <= water:
                li[i][j] = -1
    count = 0
    for i in range(N):
        for j in range(N):
            if li[i][j] == 0:
                bfs(i, j, li)
                count += 1
    cnt_li.append(count)
print(max(cnt_li))