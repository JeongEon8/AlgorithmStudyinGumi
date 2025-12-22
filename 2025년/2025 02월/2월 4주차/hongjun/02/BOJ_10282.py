import heapq

t = int(input())
INF = int(1e9)

def dijk(start, graph):
    # 최단 시간
    distance = [INF] * (n+1)

    pq = []
    distance[c] = 0
    heapq.heappush(pq, (0, start))

    while pq:
        cost, now = heapq.heappop(pq)

        if cost < distance[now]:
            continue

        for next_cost, next in graph[now]:

            if distance[next] > cost + next_cost:
                distance[next] = cost + next_cost
                heapq.heappush(pq, (cost + next_cost, next))

    res_cnt, res_time = 0, 0
    for time in distance:
        if time < INF:
            res_cnt += 1
            if time > res_time:
                res_time = time

    return res_cnt, res_time


for _ in range(t):
    n, d, c = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for i in range(d):
        a, b, s = map(int, input().split())
        graph[b].append([s, a]) # [비용, 목적지]

    res1, res2 = dijk(c, graph)

    print(res1, res2)