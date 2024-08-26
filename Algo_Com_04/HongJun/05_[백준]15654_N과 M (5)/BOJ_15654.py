from itertools import permutations

n,m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

res = list(permutations(arr, m))
for i in res:
    print(*i)