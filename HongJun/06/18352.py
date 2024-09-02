from collections import deque
import sys
input = sys.stdin.readline

n,m,k,x = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)

distance = [-1] * (n+1)

def bfs(start):
    q = deque([start])
    distance[start] = 0
    while q:
        node = q.popleft()
        for i in graph[node]:
            if distance[i] == -1:
                distance[i] = distance[node]+1
                q.append(i)
bfs(x)
if k in distance:
    for idx in range(1, n+1):
        if distance[idx] == k:
            print(idx)
else:
    print(-1)