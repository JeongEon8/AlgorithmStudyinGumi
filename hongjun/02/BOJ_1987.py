import sys
input = sys.stdin.readline

r, c = map(int, input().split())
alpha = []
for _ in range(r):
    alpha.append(list(input()))

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

result = set()
result.add(alpha[0][0])

def dfs(x, y, cnt):
    global answer
    answer = max(answer, cnt)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and alpha[nx][ny] not in result:
                result.add(alpha[nx][ny])
                dfs(nx, ny, cnt+1)
                result.remove(alpha[nx][ny])

answer = 0
dfs(0, 0, 1)
print(answer)