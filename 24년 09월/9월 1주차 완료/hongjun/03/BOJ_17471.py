# 1. 모든 번호 2그룹으로 나눈 경우 구하기 - 조합
# 2. 그룹별로 인접되는지 확인
from collections import deque
from itertools import combinations


n = int(input())
people = list(map(int, input().split()))
dict = {i+1: people[i] for i in range(n)}

# 인접한 구역 입력받아서 그래프에 넣기
graph = [[] for _ in range(n+1)]
for i in range(1, n+1):
    node = list(map(int, input().split()))
    for j in range(1, node[0]+1):
        graph[i].append(node[j])
city = [i for i in range(1, n+1)]


# 백트래킹 조합 구하기로 두 구역으로 나누기
a_group = []
b_group = []
result = []
def dfs(start, depth, cnt):
    if depth == cnt:
        if result not in b_group:
            a_group.append(list(result))
            b_group.append(list(set(city) - set(result)))
        return

    for i in range(start, n):
        result.append(city[i])
        dfs(i+1, depth+1, cnt)
        result.pop()


# 각 구역끼리 연결되어있는지 확인하는 BFS
def bfs(group):
    start = group[0]
    q = deque()
    q.append(start)

    visited = [False] * (n + 1)
    visited[start] = True
    while q:
        node = q.popleft()
        for i in graph[node]:
            if i not in group:
                continue
            if visited[i] == False:
                q.append(i)
                visited[i] = True
    return visited.count(True) == len(group)

# 해당 구역의 인구수 구하기
def get_sum(group):
    count = 0
    for i in group:
        count += dict[i]
    return count

INF = int(1e9)
answer = INF
for i in range(1, n//2+1):
    dfs(0, 0, i)
    # 조합으로 나온 두 그룹을 하나씩 뽑아서 확인
    for j in range(len(a_group)):
        A = a_group[j]
        B = b_group[j]

        if bfs(A) and bfs(B):
            a_count = get_sum(A)
            b_count = get_sum(B)

            answer = min(answer, abs(a_count - b_count))

if answer == INF:
    print(-1)
else:
    print(answer)


# for i in range(1, n//2+1):
#     comb = tuple(combinations(city, 3))
#     for tmp in comb:
#         if tmp not in b_group:
#             a_group.append(tmp)
#             b_group.append(tuple(set(city) - set(tmp)))
# print(a_group)
# print(b_group)