import heapq

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
distance = [int(1e9)] * (n+1)
parent = [0] * (n+1)    # 이전 노드를 저장하기 위함

for _ in range(m):
    a, b, c = map(int, input().split())
    # 시작, 도착, 거리
    graph[a].append([b, c])

start, end = map(int, input().split())


def dijk(start):
    q = []
    # 우선순위 큐에는 (거리, 도착 노드)
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        # 이미 최단 거리인 노드이면 스킵
        if distance[now] < dist:
            continue

        # 현재 노드와 연결된 인접 노드들 확인
        for next, c in graph[now]:
            cost = dist + c
            # 현재 노드를 거쳐서 가는게 더 최단 거리일 때
            if cost < distance[next]:
                # 최단 거리 갱신
                distance[next] = cost
                # 다음 노드로 가는 비용과 다음 노드를 우선순위 큐에 추가
                heapq.heappush(q, (cost, next))
                parent[next] = now
dijk(start)

path = [end]   # 이동 경로 탐색
tmp = end
# 출발 지점이 될때까지 탐색
while tmp != start:
    tmp = parent[tmp]
    path.append(tmp)
path.reverse()

print(distance[end])
print(len(path))
print(' '.join(map(str, path)))