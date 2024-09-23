from collections import deque
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    indegree = [0] * (N+1)
    DP = [0] * (N+1)

    time = list(map(int, input().split()))  # index가 1작음
    for i in range(K):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegree[b] += 1


    def topology():
        q = deque()
        for i in range(1, N+1):
            if indegree[i] == 0:
                q.append(i)
                DP[i] = time[i-1]

        while q:
            now = q.popleft()

            for next in graph[now]:
                indegree[next] -= 1
                DP[next] = max(DP[next], DP[now] + time[next-1])
                if indegree[next] == 0:
                    q.append(next)


    W = int(input())

    topology()
    print(DP[W])