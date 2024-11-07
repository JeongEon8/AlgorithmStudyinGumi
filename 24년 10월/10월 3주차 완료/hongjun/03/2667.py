from collections import deque


n=int(input())
li = []
for _ in range(n):
    li.append(list(map(int, input())))

dx=[1,-1,0,0]
dy=[0,0,1,-1]

def bfs(a, b):
    q = deque()
    q.append((a,b))
    li[a][b] = 0
    cnt = 1
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if li[nx][ny] == 1:
                li[nx][ny] = 0
                q.append((nx, ny))
                cnt += 1
    return cnt

result = []
for i in range(n):
    for j in range(n):
        if li[i][j] == 1:
            res = bfs(i,j)
            result.append(res)

result.sort()
print(len(result))
for i in result:
    print(i)