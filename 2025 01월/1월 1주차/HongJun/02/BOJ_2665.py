import heapq
import sys
input = sys.stdin.readline

n = int(input())
room = []
for _ in range(n):
    room.append(list(map(int, input().rstrip())))

INF = int(1e9)
best = [[INF] * n for _ in range(n)]

dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

def dijk():
    pq = []
    heapq.heappush(pq, (0, 0, 0)) # 비용, y좌표, x좌표
    best[0][0] = 0

    while pq:
        price, nowY, nowX = heapq.heappop(pq)

        # dummy 제거
        if price > best[nowY][nowX]:
            continue

        for i in range(4):
            nextY = nowY + dy[i]
            nextX = nowX + dx[i]

            # 좌표가 범위 안에 있을 때
            if 0 <= nextY < n and 0 <= nextX < n:
                tmp = room[nextY][nextX]
                # 다음 이동할 좌표가 벽일 때
                if room[nextY][nextX] == 0:
                    if best[nextY][nextX] > price + 1:
                        best[nextY][nextX] = price + 1
                        heapq.heappush(pq, (price + 1, nextY, nextX))
                # 그냥 갈 수 있으면 비용이 0
                else:
                    if best[nextY][nextX] > price:
                        best[nextY][nextX] = price
                        heapq.heappush(pq, (price, nextY, nextX))

dijk()
print(best[n-1][n-1])