# 부모를 찾으면서 값 갱신하기
def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

# 한 집합에 있으면 부모로 바꿔줌
def union(a, b, parents):
    a_root = find(a)
    b_root = find(b)
    if a_root > b_root:
        parents[a_root] = b_root
    else:
        parents[b_root] = a_root

N = int(input())
M = int(input())
com = []
for i in range(M):
    a, b, c = map(int, input().split())
    com.append((c, a, b))
parents = [i for i in range(N+1)]
com.sort()

weight = 0
cnt = 0
for cost, a, b in com:
    if find(a) != find(b):
        union(a, b, parents)
        cnt += 1
        weight += cost
        if cnt == N-1:
            break
print(weight)