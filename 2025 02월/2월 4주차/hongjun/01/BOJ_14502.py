import copy
from collections import deque
from itertools import combinations

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

n,m = map(int, input().split())

res = []

graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

# 빈칸인 곳의 좌표, 바이러스 좌표를 저장
wall = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            wall.append((i, j))

# 빈칸 중에서 3개를 조합으로 뽑아서 저장
wall_index = [i for i in range(len(wall))]
pick3 = list(combinations(wall_index, 3))

res = []

for a, b, c in pick3:
    tmp = [wall[a], wall[b], wall[c]]
    graph_tmp = copy.deepcopy(graph)
    for y, x in tmp:
        graph_tmp[y][x] = 1

    dq = deque()
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                dq.append((i, j))

    while dq:
        y, x = dq.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0<= ny < n and 0<=nx<m:
                if graph_tmp[ny][nx] == 0:
                    graph_tmp[ny][nx] = 2
                    dq.append((ny,nx))

    count = 0
    for i in range(n):
        for j in range(m):
            if graph_tmp[i][j] == 0:
                count += 1
    res.append(count)

print(max(res))