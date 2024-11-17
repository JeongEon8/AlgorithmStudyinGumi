import heapq
import sys
input = sys.stdin.readline

v, e = map(int, input().split())
st = int(input())

INF = int(1e9)
distance = [INF] * (v+1)
# 입력한 정점 정보 저장할 2차원 배열
graph = [[] for _ in range(v+1)]

for i in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))    # (도착, 비용)


hq = []
heapq.heappush(hq, (0, st))     # (비용, 위치)
distance[st] = 0

while hq:
    # 현재
    dist, now = heapq.heappop(hq)
    # 이미 비용이 더 작은 경우는 스킵
    if distance[now] < dist:
        continue

    # 현재 위치에서 갈 수 있는 노드들 탐색
    for node in graph[now]:
        cost = dist + node[1]
        next = node[0]

        if cost < distance[next]:
            distance[next] = cost
            heapq.heappush(hq, (cost, next))

for i in range(1, v+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])