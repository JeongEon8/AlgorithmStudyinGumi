N = int(input())
win = []
for _ in range(N):
    win.append(list(map(str, input().rstrip())))

node = []
res = [[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if win[i][j] != ".":
            node.append((i, j))
            res[i][j] = "*"

dx = [0, 0, -1, 1, 1, 1, -1, -1]
dy = [1, -1, 0, 0, 1, -1, 1, -1]

for y, x in node:
    for i in range(8):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < N and 0 <= nx < N:

            if res[ny][nx] != "*" and isinstance(res[ny][nx], int):
                res[ny][nx] += int(win[y][x])
                if res[ny][nx] >= 10:
                    res[ny][nx] = 'M'
for ans in res:
    print(''.join(map(str, ans)))