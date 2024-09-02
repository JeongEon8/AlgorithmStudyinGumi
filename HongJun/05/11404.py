n = int(input())
m = int(input())
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    # 연결 노선이 중복되는 경우가 있음
    # 두 비용을 비교해서 더 적은 비용으로 넣어줘야함
    graph[a][b] = min(graph[a][b], c)

# 자기 자신으로 가는 비용은 0으로 초기화
for i in range(n+1):
    graph[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == INF:
            graph[i][j] = 0

for res in graph[1:]:
    print(*res[1:])