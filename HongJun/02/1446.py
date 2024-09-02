import heapq

n, d = map(int, input().split())
INF = int(1e9)

graph = [[] for _ in range(d+1)]
distance = [INF] * (d+1)

# 바로 다음 숫자로 이동가능함
for i in range(d):
    graph[i].append((i+1, 1))

for _ in range(n):
    s, e, l = map(int, input().split())
    # 지름길의 도착 위치가 목적지보다 크지 않을때만 그래프에 추가
    if e <= d:
        graph[s].append((e, l))


def dijk(start):
    q = []
    # 시작지점 초기화
    distance[start] = 0
    # (거리, 도착지점)
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for tmp in graph[now]:
            cost = tmp[1] + dist
            if cost < distance[tmp[0]]:
                distance[tmp[0]] = cost

                heapq.heappush(q, (cost, tmp[0]))

dijk(0)

print(distance[d])