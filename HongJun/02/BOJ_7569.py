from collections import deque

m, n, h = map(int, input().split()) # 가로, 세로, 높이

tomato = []
for i in range(h):
    box = []
    for j in range(n):
        line = list(map(int, input().split()))
        box.append(line)
    tomato.append(box)

# h, n, m
# 6방향 (상, 하, 좌, 우, 앞, 뒤)
dz = [0, 0, 0, 0, 1, -1]
dy = [1, -1, 0, 0, 0, 0]
dx = [0, 0, -1, 1, 0, 0]
q = deque()


def bfs():
    while q:
        z, y, x = q.popleft()
        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]
            if 0<=nx<m and 0<=ny<n and 0<=nz<h:
                if tomato[nz][ny][nx] == 0:
                    tomato[nz][ny][nx] = tomato[z][y][x] + 1
                    q.append((nz, ny, nx))


for z in range(h):
    for y in range(n):
        for x in range(m):
            if tomato[z][y][x] == 1:
                q.append((z, y, x))
bfs()

result = 0
flag = False
for z in range(h):
    for y in range(n):
        for x in range(m):
            if tomato[z][y][x] == 0:
                flag = True
        result = max(result, max(tomato[z][y]))

if flag:
    print(-1)
else:
    print(result - 1)