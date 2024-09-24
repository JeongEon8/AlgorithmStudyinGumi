n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = 0
# 자신을 제외한 무한대가 아닌 노드들이 n-1개
for i in range(1, n+1):
    cnt = 0
    for j in range(1, n+1):
        if graph[i][j] != INF or graph[j][i] != INF:
            cnt += 1

    if cnt == (n-1):
        result += 1
print(result)