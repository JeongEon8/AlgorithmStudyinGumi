import heapq

n, m, r = map(int, input().split()) # 지역 수, 수색범위, 길의 개수
items = list(map(int, input().split()))
INF = int(1e9)


graph = [[] for _ in range(n+1)]


for i in range(r):
    a, b, l = map(int, input().split())
    graph[a].append((b, l))
    graph[b].append((a, l))


def dijk(st):
    distance = [INF] * (n + 1)
    hq = []
    heapq.heappush(hq, (0, st)) # 시작하는 지점 거리는 0
    distance[st] = 0

    while hq:
        dist, now = heapq.heappop(hq)
        if distance[now] < dist:
            continue

        for node in graph[now]: # 현재 위치와 연결된 노드들 탐색
            cost = node[1] + dist
            next = node[0]
            if cost < distance[next]:
                distance[next] = cost
                heapq.heappush(hq, (cost, next))

    score = 0
    for i in range(1, n+1):
        if distance[i] <= m:
            score += items[i-1]
    return score


answer = []
for i in range(1, n+1):
    answer.append(dijk(i))

print(max(answer))