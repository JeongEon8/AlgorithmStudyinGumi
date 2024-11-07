from collections import deque
from itertools import combinations
import sys
input = sys.stdin.readline

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

n, m = map(int, input().split())
graph = []
for i in range(n):
    li = list(map(int, input().split()))
    graph.append(li)

matrix = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            matrix.append((i, j))

L = len(matrix)
indexes = [i for i in range(L)]
pick = list(combinations(indexes, 3))

result = []

for a, b, c in pick:
    one = matrix[a]
    two = matrix[b]
    three = matrix[c]

    graph[one[0]][one[1]] = 1
    graph[two[0]][two[1]] = 1
    graph[three[0]][three[1]] = 1

    visited = [[False]*m for _ in range(n)]

    dq = deque()
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                dq.append((i, j))
                visited[i][j] = True
            elif graph[i][j] == 1:
                visited[i][j] = True

    while dq:
        x, y = dq.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == False and graph[nx][ny] == 0:
                    dq.append((nx, ny))
                    visited[nx][ny] = True

    graph[one[0]][one[1]] = 0
    graph[two[0]][two[1]] = 0
    graph[three[0]][three[1]] = 0

    count = 0
    for i in range(n):
        for j in range(m):
            if visited[i][j] == False:
                count += 1
    result.append(count)

print(max(result))