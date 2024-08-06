from collections import deque

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

res = 0


def bfs(start):
    visited[start] = 1
    q = deque([start])
    while q:
        node = q.popleft()
        for i in graph[node]:
            if visited[i] == 0:
                visited[i] = 1
                q.append(i)


for i in range(1, n + 1):
    if visited[i] == 0:
        bfs(i)
        res += 1

print(res)