from collections import deque

n, m = map(int, input().split())  # 세로, 가로
li = []
for _ in range(n):
    li.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[False] * m for _ in range(n)]

def bfs(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and li[nx][ny] != 0:
                q.append((nx, ny))
                visited[nx][ny] = True
                li[nx][ny] = li[x][y]+1

# 배열을 돌면서 2 찾아서 0으로 만들고 거기서부터 bfs
# 도달지점인 2를 찾으면 바로 빠져나가기 위해서 flag 설정
flag = False
for i in range(n): # 세로
    for j in range(m): # 가로
        # 한 줄에서 2를 찾으면 flag를 표시하고 나감
        if li[i][j] == 2:
            li[i][j] = 0
            flag = True
            break
    # 2를 찾았으면 bfs 한 번 돌리고 나감
    if flag:
        bfs(i, j)
        break

# 방문하지 않았고 0이 아닌 부분 = 갈 수 없음
for i in range(n):
    for j in range(m):
        if not visited[i][j] and li[i][j] != 0:
            li[i][j] = -1

for tmp in li:
    print(*tmp)