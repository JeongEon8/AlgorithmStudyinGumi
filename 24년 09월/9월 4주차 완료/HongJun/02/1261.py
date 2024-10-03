from collections import deque

n,m = map(int, input().split())
miro = []
for _ in range(m):
    miro.append(list(input()))

for i in range(m):
    for j in range(n):
        miro[i][j] = int(miro[i][j])

# 가중치
visited = [[-1]*n for _ in range(m)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = 0

    while q:
        y, x = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=ny<m and 0<=nx<n and visited[ny][nx] == -1:
                # 벽이 없음 -> 덱의 앞 부분에 위치 추가
                if miro[ny][nx] == 0:
                    q.appendleft((ny, nx))
                    visited[ny][nx] = visited[y][x]

                # 벽이 있음 -> 덱의 끝에 추가
                else:
                    q.append((ny, nx))
                    visited[ny][nx] = visited[y][x] + 1
                # for i in visited:
                #     print(i)
                # print()


bfs(0, 0)

print(visited[m-1][n-1])