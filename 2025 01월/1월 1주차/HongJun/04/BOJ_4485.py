import heapq

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
problem = 1

def move_min_cost(a, b, problem):
    q = []
    st_cost = li[a][b]
    heapq.heappush(q, (st_cost, a, b))
    visited[a][b] = st_cost

    while q:
        cost, y, x = heapq.heappop(q)
        if y == N - 1 and x == N - 1:
            print(f'Problem {problem}: {visited[y][x]}')

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < N:
                # 다음 위치로 이동할 때 드는 비용
                dist = cost + li[ny][nx]

                # 기존 비용과 다음 위치 이동 비용 비교
                if dist < visited[ny][nx]:
                    # 더 작으면 갱신하고 우선순위 큐에 삽입
                    visited[ny][nx] = dist
                    heapq.heappush(q, (dist, ny, nx))

while 1:
    N = int(input())
    if N == 0:
        break

    li = []
    for _ in range(N):
        li.append(list(map(int, input().split())))

    INF = int(1e9)
    visited = [[INF]*(N) for _ in range(N)]

    move_min_cost(0, 0, problem)
    problem += 1