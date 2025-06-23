n=int(input())
dp = [-1] * 5001
dp[3] = 1
dp[5] = 1

for i in range(6, n+1):
    tmp1 = dp[i-3]
    tmp2 = dp[i-5]

    if tmp1 != -1 and tmp2 != -1:
        dp[i] = min(tmp1, tmp2) + 1
    elif tmp1 != -1:
        dp[i] = tmp1 + 1
    elif tmp2 != -1:
        dp[i] = tmp2 + 1

print(dp[n])