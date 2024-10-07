n, k = map(int, input().split())
li = list(map(int, input().split()))
tmp = []
for i in range(1, n):
    tmp.append(li[i] - li[i-1])
tmp.sort()
sum = 0
for i in range(n-k):
    sum += tmp[i]
print(sum)