from collections import deque
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    l = int(input())
    a, b = map(int, input().split())
    c, d = map(int, input().split())

    position = [[0] * l for _ in range(l)]

    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]

    def bfs():
        q = deque()
        q.append([a, b])

        while q:
            x, y = q.popleft()
            if x == c and y == d:
                return position[x][y]
            
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0<=nx<l and 0<=ny<l and position[nx][ny] == 0:
                    position[nx][ny] = position[x][y] + 1
                    q.append([nx, ny])

    res = bfs()
    print(res)