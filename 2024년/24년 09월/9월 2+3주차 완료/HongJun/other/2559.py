# 수열
n, k = map(int, input().split())
date = list(map(int, input().split()))

res = sum(date[:k])
result = [res]
for i in range(1, n - k + 1):
    res = res - date[i-1] + date[i+k-1]
    result.append(res)
print(max(result))