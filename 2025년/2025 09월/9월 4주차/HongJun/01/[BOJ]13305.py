import sys
input = sys.stdin.readline

n=int(input())
km=list(map(int, input().split()))
liter=list(map(int, input().split()))

res = km[0]*liter[0]
cost=liter[0]
dist=0

for i in range(1, n-1):
    if cost > liter[i]:
        res += dist*cost
        dist = km[i]
        cost = liter[i]
    else:
        dist += km[i]

    if i == n-2:
        res += dist*cost
print(res)