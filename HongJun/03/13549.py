import heapq

n, k = map(int, input().split())
INF = int(1e9)
distance = [INF] * (100001)

# 시작 위치 설정
distance[n] = 0
q = []
heapq.heappush(q, (0, n))

while q:
    # 비용, 현재 위치
    cost, now = heapq.heappop(q)
    # 이동할 수 있는 위치 좌표 리스트. (비용, 도착 위치)
    location = [(0, now*2), (1, now-1), (1, now+1)]

    if distance[now] < cost:
        continue

    # 이동할 수 있는 위치 (비용, 도착 위치)
    for dist, end in location:
        # 도착 위치가 범위를 벗어나지 않는지 확인
        if end < 0 or end > 100000:
            continue
        # 위치까지 가는 비용이 더 적을 경우
        if cost + dist < distance[end]:
            distance[end] = cost + dist
            # 우선순위 큐에 다음 위치에서 갈 수 있는 위치와 비용 추가
            heapq.heappush(q, (cost+dist, end))

print(distance[k])







