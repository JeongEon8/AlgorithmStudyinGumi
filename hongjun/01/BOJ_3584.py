import sys
sys.setrecursionlimit(10**6)

T = int(input())

def dfs_a(start):
    a_ancestor.append(start)
    if not parent[start]:
        return
    dfs_a(parent[start])

def dfs_b(start):
    b_ancestor.append(start)
    if not parent[start]:
        return
    dfs_b(parent[start])

for test_case in range(1, T+1):
    n = int(input())
    parent = [0] * (n+1)
    for _ in range(n-1):
        x, y = map(int, input().split())
        parent[y] = x
    a, b = map(int, input().split())
    a_ancestor = [0]
    b_ancestor = [0]

    dfs_a(a)
    dfs_b(b)

    i = -1
    while a_ancestor[i] == b_ancestor[i]:
        i -= 1

    result = a_ancestor[i+1]
    print(result)