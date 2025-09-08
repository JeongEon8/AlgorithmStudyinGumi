import sys
input = sys.stdin.readline

n,m = map(int, input().split())
wait = list(map(int, input().split()))
fri = list(map(int, input().split()))
cnt = 0

idx = []
for i in fri:
    idx.append(wait.index(i))
idx.sort()

for i in range(m):
    if i not in idx:
        cnt += 1
print(cnt)