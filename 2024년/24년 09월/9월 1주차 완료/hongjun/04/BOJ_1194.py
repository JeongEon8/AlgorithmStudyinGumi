from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def haveKey(current_key, door):
    value = current_key & (1 << (ord(door) - ord('A')))
    if value:
        return True
    else:
        return False

def bfs(x, y):
    q = deque()
    q.append((x, y, 0, 0)) # x좌표, y좌표, 이동수, 키값
    # 3차원 배열 [x좌표][y좌표][6비트 a,b,c,d,e,f]
    check = [[[False]*(1<<6) for _ in range(50)] for _ in range(50)]
    check[x][y][0] = True

    while q:
        x, y, cnt, key = q.popleft()
        if graph[x][y] == '1':
            return cnt

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<n and 0<=ny<m:

                if not check[nx][ny][key]:
                    if graph[nx][ny] == '1' or graph[nx][ny] == '.':
                        check[nx][ny][key] = True
                        q.append((nx, ny, cnt+1, key))

                    elif 'a' <= graph[nx][ny] <= 'f':
                        tmp_key = key | (1 << (ord(graph[nx][ny]) - ord('a')))
                        # print(type(tmp_key), type(nx), type(ny))
                        check[nx][ny][tmp_key] = True
                        q.append((nx, ny, cnt+1, tmp_key))

                    elif 'A' <= graph[nx][ny] <= 'Z':
                        if haveKey(key, graph[nx][ny]):
                            check[nx][ny][key] = True
                            q.append((nx, ny, cnt+1, key))
    return -1


start_x = 0
start_y = 0
n, m = map(int, input().split()) # 세로, 가로
graph = [list(map(str, input().rstrip())) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if graph[i][j] == '0':
            start_x, start_y = i, j
            graph[i][j] = '.'
answer = bfs(start_x, start_y)
print(answer)