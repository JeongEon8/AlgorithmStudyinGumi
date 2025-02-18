import heapq

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [int(1e9)] * (N+1)

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))


def dijk():
    pq = []
    heapq.heappush(pq, (0, 1)) # 비용, 위치
    distance[1] = 0

    while(pq):
        now_cost, now = heapq.heappop(pq)

        if now_cost > distance[now]:
            continue

        for node in graph[now]:
            next = node[1]
            next_cost = node[0] + now_cost

            if next_cost < distance[next]:
                distance[next] = next_cost
                heapq.heappush(pq, (next_cost, next))

dijk()
print(distance[-1])