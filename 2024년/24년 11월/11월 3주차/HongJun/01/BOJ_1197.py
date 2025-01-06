import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

v, e = map(int, input().split())
nodes = []
parent = [i for i in range(v + 1)]


# root노드를 찾음
def find(x):
    # root가 자기 자신이 아닌 경우
    if x != parent[x]:
        # root노드 찾을 때 까지 재귀 반복
        parent[x] = find(parent[x])
    # 찾은 부모를 현재 노드의 부모로 설정
    return parent[x]


def union(a, b):
    # 두 노드의 부모 노드 찾기
    root_a = find(a)
    root_b = find(b)
    # 부모 노드를 더 작은 숫자로 바꿔줌
    if root_a > root_b:
        parent[root_a] = root_b
    else:
        parent[root_b] = root_a


for _ in range(e):
    a, b, c = map(int, input().split())
    nodes.append((c, a, b))
nodes.sort()

cnt = 0  # 만들어진 간선의 개수
result = 0  # 가중치의 합

for node in nodes:
    # 두 노드의 부모가 다르면
    if find(node[1]) != find(node[2]):
        # 유니온해서 공통 부모로 변경
        union(node[1], node[2])
        # 간선 수 하나 올림
        cnt += 1
        # 가중치 더함
        result += node[0]

        # 간선이 다 연결됐으면 나옴
        if cnt == v - 1:
            break

print(result)