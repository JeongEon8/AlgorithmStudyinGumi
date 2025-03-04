import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().strip())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 3차원 배열 사용
visited = [[[0]*2 for _ in range(m)] for _ in range(n)]


def bfs():
    dq = deque()
    dq.append((0, 0, 0))  # y좌표, x좌표, 벽 부순 횟수
    visited[0][0][0] = 1    # 방문 처리

    while dq:
        # break_wall = 벽을 부순 횟수
        y, x, break_wall = dq.popleft()

        # 끝에 도달하면 거리 리턴
        if y == n-1 and x == m-1:
            return visited[y][x][break_wall]
    
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
    
            if 0 <= ny < n and 0 <= nx < m:
                # 다음 위치에 벽이 없는 경우엔 그냥 이동
                if graph[ny][nx] == 0 and visited[ny][nx][break_wall] == 0:
                    visited[ny][nx][break_wall] = visited[y][x][break_wall]+1
                    dq.append((ny, nx, break_wall))
    
                # 벽이 있는 경우 -> 벽을 부순 횟수가 0이어야 한 번 깰 수 있음
                if graph[ny][nx] == 1 and break_wall == 0 and visited[ny][nx][1] == 0:
                    # 다음 위치는 벽을 1번 부쉈음
                    visited[ny][nx][1] = visited[y][x][break_wall] + 1
                    dq.append((ny, nx, 1))
    return -1

result = bfs()
print(result)