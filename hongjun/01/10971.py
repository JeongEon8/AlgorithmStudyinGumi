n = int(input())
graph = []
visited = [False] * (n+1)
MIN = int(1e9)

def dfs(start, now, cnt, sum):
    global MIN
    if cnt == n:
        if graph[now][start] != 0:
            MIN = min(MIN, sum + graph[now][start])
        return

    for i in range(n):
        if visited[i] == False and graph[now][i] != 0:
            visited[i] = True
            dfs(start, i, cnt+1, sum + graph[now][i])
            visited[i] = False


for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    visited[i] = True
    dfs(i, i, 1, 0)
    visited[i] = False

print(MIN)