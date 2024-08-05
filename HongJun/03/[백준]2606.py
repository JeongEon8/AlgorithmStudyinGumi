n = int(input())
m = int(input())

computer = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
for i in range(m):
    u, v = map(int, input().split())
    computer[u].append(v)
    computer[v].append(u)


def dfs(s):
    visited[s] = True
    for idx in computer[s]:
        if not visited[idx]:
            dfs(idx)


dfs(1)
print(visited.count(True) - 1)