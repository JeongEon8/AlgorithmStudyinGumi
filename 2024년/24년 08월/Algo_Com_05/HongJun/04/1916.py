import heapq

n = int(input())
m = int(input())
INF = int(1e9)
distance = [INF] * (n+1)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    # (비용, 도작 지점)
    graph[a].append((c, b))

start, end = map(int, input().split())

def dijk(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        cost, now = heapq.heappop(q)

        if distance[now] < cost:
            continue
        for _cost, end in graph[now]:
            tmp = cost + _cost
            if distance[end] > tmp:
                distance[end] = tmp
                heapq.heappush(q, (tmp, end))

dijk(start)
print(distance[end])