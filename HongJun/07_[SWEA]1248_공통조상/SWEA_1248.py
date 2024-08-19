# 모든 노드들의 깊이를 찾기 위해서 스택을 사용한다.
from collections import deque


def check_depth(node, child, depth):
    stack = [(node, 0)]
    while stack:
        current, cnt = stack.pop()
        depth[current] = cnt
        for i in child[current]:
            stack.append((child, cnt+1))


def find_parent(u, v, parent, depths):
    # 두 노드의 깊이 맞춤
    while depths[u] > depths[v]:
        u = parent[u]
    while depths[v] > depths[u]:
        v = parent[v]

    # 두 노드가 같아질 때까지 위로 이동
    while u != v:
        u = parent[u]
        v = parent[v]

    return u

# 서브트리의 크기 -> bfs로 정점 개수 찾기
def bfs(start, childrens):
    count = 1
    q = deque()

    while q:
        current = q.pop()
        for node in childrens[current]:
            count += 1
            q.append(node)
    return count




T = int(input())
for test_case in range(1, T + 1):
    V, E, a, b = map(int, input().split())
    tree = list(map(int, input().split()))

    parents = [0] * (V+1)       # 각 노드의 부모
    childrens = [[] for _ in range(V+1)]    # 자식 노드 저장
    # 각 노드들의 깊이
    depth = [0] * (V+1)

    for i in range(0, E, 2):
        parent = tree[i]
        child = tree[i+1]
        childrens[parent].append(child)
        parents[child] = parent

    # 1번 루트 노드부터 각 노드의 깊이 구하기
    check_depth(1, childrens, depth)
    # 노드의 공통 조상 찾기
    result = find_parent(a, b, parents, depth)
    # 서브 트리 크기
    count = bfs(result, childrens)

    print(f'#{test_case} {result} {count}')
