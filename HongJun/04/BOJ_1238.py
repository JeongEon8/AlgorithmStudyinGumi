import sys
input = sys.stdin.readline
import heapq
INF = int(1e9)

n, m, x = map(int, input().split())

graph = [[] for _ in range(n+1)]


for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijk(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        dis, now = heapq.heappop(q)

        if dist[now] < dis:
            continue

        for node, weight in graph[now]:
            cost = dis + weight
            if cost < dist[node]:
                dist[node] = cost
                heapq.heappush(q, (cost, node))
    return dist


# 각 경로까지 도달하는 비용 저장
path = [[]]
for i in range(1, n+1):
    dist = [INF] * (n+1)
    path.append(dijk(i))

# 목적지까지 도달하는 시간 저장
time = []
for i in range(1, n+1):
    time.append(path[i][x]+path[x][i])

print(max(time))