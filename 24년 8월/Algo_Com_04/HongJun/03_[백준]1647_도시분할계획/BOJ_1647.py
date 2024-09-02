n, m = map(int, input().split())
roads = []
parents = [i for i in range(n + 1)]


def find(x):
    # 노드 x의 부모노드가 자기자신이 아니면
    if x != parents[x]:
        # 노드 x의 부모노드 = 최상위 부모노드 탐색 재귀함수
        parents[x] = find(parents[x])
    # 현재노드의 최상위 부모노드 return
    return parents[x]


def union(a, b):
    root_a = find(a)
    root_b = find(b)
    if root_a > root_b:
        parents[root_a] = root_b
    else:
        parents[root_b] = root_a


for _ in range(m):
    a, b, c = map(int, input().split())
    roads.append((c, a, b))
roads.sort()

# 마지막에 연결되는 길을 없애주면 2개로 나뉨
last = 0
result = 0
for road in roads:
    cost = road[0]
    h1 = road[1]
    h2 = road[2]

    # 서로 부모 노드가 다른 경우
    if find(h1) != find(h2):
        union(h1, h2)
        result += cost
        # 마지막 가장 비용이 높은 길
        last = cost
print(result - last)
