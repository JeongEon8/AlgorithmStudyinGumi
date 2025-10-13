n = int(input())
time = sorted(list(map(int, input().split())))
res = [0] * (n+1)

for i in range(1, n+1):
    for j in range(i):
        res[i] += time[j]

print(sum(res))